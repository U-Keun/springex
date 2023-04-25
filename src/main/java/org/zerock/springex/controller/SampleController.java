package org.zerock.springex.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // 해당 클래스가 스프링 MVC에서 컨트롤러 역할을 한다! -> 스프링 빈(Bean)
@Log4j2
public class SampleController {

    @GetMapping("/hello") // GET 방식으로 들어오는 Request를 처리; /hello 라는 경로를 호출할 때 동작한다.
    public void hello() {
        log.info("hello............");
    }
}
