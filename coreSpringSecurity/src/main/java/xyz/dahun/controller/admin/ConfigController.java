package xyz.dahun.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigController {

    @GetMapping("/config")
    public String adminConfig(){
        return "admin/config";
    }
}
