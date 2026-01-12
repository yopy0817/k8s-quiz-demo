package com.example.demo.component;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoJpaRepository demoJpaRepository;

    @GetMapping("/example")
    public String example(HttpServletRequest request) {

        String addr = request.getRemoteAddr();
        Demo demo = demoJpaRepository.save( Demo.builder().ipAddress(addr).build() );
        log.info( "🕒 접속아이피: " + addr + " 인서트에 성공했습니다.");

        return "<h3>hello k8s:" + demo.getTimestamp() + "</h3>";
    }
}
