package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springex.dto.TodoDTO;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링 MVC에서 컨트롤러 역할을 한다! -> 스프링 빈(Bean)
@Log4j2
public class SampleController {

    @GetMapping("/hello") // GET 방식으로 들어오는 Request를 처리; /hello 라는 경로를 호출할 때 동작한다.
    public void hello() {
        log.info("hello............");
    }

    @GetMapping("/ex1")
    public void ex1(String name, int age) {
        log.info("ex1...............");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("ex2")
    public void ex2(@RequestParam(name = "name", defaultValue = "AAA") String name,
                    @RequestParam(name = "age", defaultValue = "20") int age) {
        log.info("ex2...........");
        log.info("name: " + name);
        log.info("age: " + age);
    }

    @GetMapping("/ex3")
    public void ex3(LocalDate dueDate) {
        log.info("ex3..........");
        log.info("dueDate: " + dueDate);
    }

    @GetMapping("/ex4")
    public void ex4(Model model) {

        log.info("---------------------");
        model.addAttribute("message", "Hello World");
    }

    @GetMapping("/ex4_1")
    public void ex4_1(@ModelAttribute("dto") TodoDTO todoDTO, Model model) {
        // @ModelAttribute : JSP에서는 ${dto}와 같은 이름의 변수로 처리할 수 있다.
        log.info(todoDTO);
    }

    @GetMapping("/ex5")
    public String ex5(RedirectAttributes redirectAttributes) {
        // name이라는 이름의 데이터를 전달
        redirectAttributes.addAttribute("name", "ABC");
        // result라는 이름의 데이터를 전달하고 삭제
        redirectAttributes.addFlashAttribute("result", "success");

        // /ex6 경로를 호출 -> /ex5에 해당하는 JSP는 필요하지 않음.
        return "redirect:/ex6";
    }

    @GetMapping("/ex6")
    public void ex6() {

    }

    @GetMapping("/ex7")
    public void ex7(String p1, int p2) {
        log.info("p1..........." + p1);
        log.info("p2..........." + p2);
    }
}
