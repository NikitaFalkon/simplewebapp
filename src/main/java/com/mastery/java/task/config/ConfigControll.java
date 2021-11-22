package com.mastery.java.task.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigControll {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public String all() {
        return "all";
    }

    @GetMapping("/creating")
    public String create() {
        return "create";
    }

    @GetMapping("/redacting")
    public String redact() {
        return "redact";
    }

    @GetMapping("/deleting")
    public String delete() {
        return "delete";
    }

}
