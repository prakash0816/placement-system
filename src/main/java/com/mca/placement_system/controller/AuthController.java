package com.mca.placement_system.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session) {

        // Simple demo login (fresher-friendly)
        if(email.equals("admin@gmail.com") && password.equals("admin123")) {
            session.setAttribute("user", email);
            return "success";
        }
        return "fail";
    }

    @GetMapping("/check-session")
    public boolean checkSession(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
