package com.cdv.mobili.service;

import javax.ejb.Stateless;

@Stateless
public class HelloWorldServiceBean {
    public HelloWorldServiceBean() {
    }
    public String sayHello() {
        return "Hello, World!";
    }
}