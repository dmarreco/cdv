package com.cdv.mobili.web.controller;

/*
 *  The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an EL name
 *  Read more about the @Model stereotype in this FAQ:
 *  http://sfwk.org/Documentation/WhatIsThePurposeOfTheModelAnnotation
 */

import javax.enterprise.inject.Model;

@Model
public class HelloWorldController {

//    @Inject
//    private HelloWorldServiceBean helloWorldService;
//
//    @Produces
//    @Named
//    public String getWordsSpokenByMyService() {
//        return helloWorldService.sayHello();
//    }
}
