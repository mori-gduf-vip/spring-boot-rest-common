package com.mori.api.business.controller;


import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/hello")
    public ResponseEntity<Object> hello(){
        return ResponseEntity.ok(ImmutableMap.
                builder().put("msg","ok").put("code",200).build());
    }
}
