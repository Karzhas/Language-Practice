package kz.karzhas.languagepractice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping(value = "/test")
    String test(){
        var s = "???";
        return s;
    }
}
