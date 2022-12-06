package my.web.app.shop.controllers;

import my.web.app.shop.models.Book;
import my.web.app.shop.models.CalcModel;
import my.web.app.shop.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CalcController {

    @GetMapping("/calc")
    public String main(Model model) {
        return "calc";
    }

    @PostMapping("/calc")
    public String getResult(@RequestParam int n1,
                            @RequestParam int n2,
                            @RequestParam String sign,Model model) {
        model.addAttribute("res", CalcModel.getResult(n1,n2,sign));
        return "result";
    }

    @PostMapping("/calc2")
    public String getResult2(@RequestParam int num1,
                             @RequestParam int num2,
                             @RequestParam String sign,Model model) {
        model.addAttribute("res", CalcModel.getResult(num1,num2,sign));
        return "calc";
    }
}
