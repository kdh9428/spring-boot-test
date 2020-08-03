package xyz.dahun.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MessageController {

    @PostMapping("/messages")
    public String message() throws Exception{
        return "user/messages";
    }

    @PostMapping("/api/messages")
    @ResponseBody
    public String apiMessage(){
        return "messages ok";
    }
}
