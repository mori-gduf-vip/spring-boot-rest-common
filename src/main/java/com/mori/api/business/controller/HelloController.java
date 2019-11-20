package com.mori.api.business.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hello")
public class HelloController {

    @Reference(url = "dubbo://127.0.0.1:20880")
    private IHelloService iHelloService;

    @RequestMapping("/hello")
    public ResponseEntity<Object> hello(){

        return ResponseEntity.ok(ImmutableMap.
                builder().put("msg","ok").put("code",200).build());
    }
}
