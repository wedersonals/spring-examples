package br.wals.springsecuritybasicauth.controller;

import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/protected")
@RolesAllowed("USER")
public class ProtectedController {

    @GetMapping("/data")
    public String getData() {
        return "<h1 style=\"color: red;\">Page Protected!</h1>" +
                "<div>" +
                "<a href=\"/\">Home</a><br>" +
                "<a href=\"/protected/data/1\">Next</a><br>" +
                "</div>";
    }

    @GetMapping("/data/1")
    public String getDataFirst() {
        return "<h1 style=\"color: red;\">Page Protected - First!</h1>" +
                "<div>" +
                "<a href=\"/\">Home</a><br>" +
                "</div>";
    }
}
