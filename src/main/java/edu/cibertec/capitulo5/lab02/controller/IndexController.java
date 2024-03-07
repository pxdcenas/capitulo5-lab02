package edu.cibertec.capitulo5.lab02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "dashboard";
    }

    @GetMapping("/ip")
    @ResponseBody
    public String json() {
        String ip = "{\"origin\": \"20.225.105.10\"}";
        return ip;
    }
}
