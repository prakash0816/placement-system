const API = "/api/students";

function loadStudents() {
    fetch(API)
        .then(r => r.json())
        .then(render)
        .catch(err => console.error("Load error", err));
}
function render(data) {
    const table = document.getElementById("tableBody");
    table.innerHTML = "";

    const isAdmin = window.location.pathname.includes("dashboard");

    data.forEach(s => {
        table.innerHTML += `
        <tr>
            <td>${s.rollNumber}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.department}</td>
            <td>${s.year}</td>
            <td>${s.cgpa}</td>
            <td>${s.skill}</td>
            ${isAdmin ? `<td><button onclick="deleteStudent(${s.id})">Delete</button></td>` : ""}
        </tr>`;
    });
}



function addStudent() {
    const roll = document.getElementById("roll").value.trim();
    const name = document.getElementById("name").value.trim();
    const email = document.getElementById("email").value.trim();
    const dept = document.getElementById("dept").value.trim();
    const year = document.getElementById("year").value.trim();
    const phone = document.getElementById("phone").value.trim();
    const cgpa = document.getElementById("cgpa").value.trim();
    const skill = document.getElementById("skill").value.trim();

    if (!roll || !name || !email || !dept || !year || !cgpa || !skill) {
        alert("Please fill all required fields");
        return;
    }

    const data = {
        rollNumber: roll,
        name,
        email,
        department: dept,
        year: parseInt(year),
        phone,
        cgpa: parseFloat(cgpa),
        skill
    };

    fetch("/api/students", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
    .then(res => {
        if (!res.ok) throw new Error();
        return res.json();
    })
    .then(() => {
        clearForm();
        loadStudents();
    })
    .catch(() => alert("Error adding student"));
}



function deleteStudent(id) {
    fetch(API + "/" + id, { method: "DELETE" })
        .then(() => loadStudents());
}

function clearForm() {
    ["roll", "rollNumber", "name", "email", "department", "dept", "year", "phone", "cgpa", "skill"]
        .forEach(id => {
            const el = document.getElementById(id);
            if (el) el.value = "";
        });
}

function searchStudents() {
    const q = document.getElementById("search").value.trim();

    if (q === "") {
        loadStudents();
        return;
    }

    fetch(API + "/search?q=" + encodeURIComponent(q))
        .then(r => r.json())
        .then(render)
        .catch(err => console.error("Search error", err));
}


loadStudents();
