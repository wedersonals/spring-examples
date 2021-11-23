package br.wals.springsecuritybasicauth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/unprotected")
public class UnprotectedController {

    @GetMapping("/data")
    public String getData() {
        return "<h1>Page unprotected!</h1>" +
                "<div>" +
                "<a href=\"/\">Home</a><br>" +
                "<a href=\"/unprotected/data/1\">Next</a><br>" +
                "</div>";
    }

    @GetMapping("/data/1")
    public String getDataFirst() {
        return "<h1>Page unprotected - First!</h1>" +
                "<div>" +
                "<a href=\"/\">Home</a><br>" +
                "</div>";
    }
}
