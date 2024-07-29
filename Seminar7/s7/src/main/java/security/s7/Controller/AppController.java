package security.s7.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/public-data")
    public String publicData() {
        return "public-data";
    }

    @GetMapping("/private-data")
    public String privateData() {return "private-data";}

    @GetMapping("/login")
    public String login(){return "login-page";}
}
