const API = "http://localhost:8080/students";
let editId = null;

function toast(msg) {
    const t = document.getElementById("toast");
    t.innerText = msg;
    t.style.opacity = 1;
    setTimeout(() => t.style.opacity = 0, 2500);
}

function clearErrors() {
    ["name","email","skill","cgpa"].forEach(id => {
        document.getElementById(id + "Error").innerText = "";
    });
}

function validate(student) {
    let ok = true;
    clearErrors();

    if (!student.name.trim()) {
        nameError.innerText = "Name required";
        ok = false;
    }

    if (!student.email.includes("@")) {
        emailError.innerText = "Invalid email";
        ok = false;
    }

    if (!student.skill.trim()) {
        skillError.innerText = "Skill required";
        ok = false;
    }

    if (student.cgpa < 0 || student.cgpa > 10) {
        cgpaError.innerText = "CGPA 0–10 only";
        ok = false;
    }

    return ok;
}

function loadStudents() {
    fetch(API).then(r => r.json()).then(render);
}

function render(data) {
    tableBody.innerHTML = "";
    data.forEach(s => {
        tableBody.innerHTML += `
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.email}</td>
                <td>${s.skill}</td>
                <td>${s.cgpa}</td>
                <td>
                    <button onclick="edit(${s.id},'${s.name}','${s.email}','${s.skill}',${s.cgpa})">✏️</button>
                    <button onclick="remove(${s.id})">❌</button>
                </td>
            </tr>`;
    });
}

function addStudent() {
    const student = {
        name: name.value,
        email: email.value,
        skill: skill.value,
        cgpa: cgpa.value
    };

    if (!validate(student)) return;

    const method = editId ? "PUT" : "POST";
    const url = editId ? API + "/" + editId : API;

    fetch(url, {
        method,
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(student)
    }).then(() => {
        toast(editId ? "Updated successfully" : "Added successfully");
        editId = null;
        clearForm();
        loadStudents();
    });
}

function remove(id) {
    fetch(API + "/" + id, {method:"DELETE"})
        .then(() => {
            toast("Deleted successfully");
            loadStudents();
        });
}

function edit(id,n,e,s,c) {
    editId = id;
    name.value = n;
    email.value = e;
    skill.value = s;
    cgpa.value = c;
}

function searchSkill() {
    fetch(API + "/search?skill=" + search.value)
        .then(r => r.json())
        .then(render);
}

function clearForm() {
    name.value = "";
    email.value = "";
    skill.value = "";
    cgpa.value = "";
}

window.onload = loadStudents;
