package nuc.edu.phg.blog.controller;

import com.sun.org.glassfish.gmbal.ParameterNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LogController {

    @RequestMapping("/")
    public String index(){
        return "user/index";
    }

    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        @RequestParam("verifycode")String verifycode,
                        HttpSession session){
        if (username == null || username.equals("")){
            session.setAttribute("errorMsg","用户名不能为空");
            return "user/login";
        }
        if (password == null || password.equals("")){
            session.setAttribute("errorMsg","密码不能为空");
            return "user/login";
        }
        if (verifycode == null || verifycode.equals("")){
            session.setAttribute("errorMsg","验证码不能为空");
            return "user/login";
        }
        String verify = session.getAttribute("verifyCode")+"";
        if (!verify.equals(verifycode)){
            session.setAttribute("error","验证码错误");
            return "user/login";
        }

        return "user/login";

    }


}
