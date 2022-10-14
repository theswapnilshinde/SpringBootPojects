package com.ldap.Ldaplogin.jwt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController
{
    @GetMapping
    public String resource(){
        return "Hello World";
    }

}