package com.cdv.mobili.web.controller;

/*
 *  The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an EL name
 *  Read more about the @Model stereotype in this FAQ:
 *  http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
 */

import com.cdv.mobili.service.HelloWorldServiceBean;

import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

@Model
public class HelloWorldController {

    @Inject
    private HelloWorldServiceBean helloWorldService;

    @Produces
    @Named
    public String getWordsSpokenByMyService() {
        return helloWorldService.sayHello();
    }
}
