package com.cdv.mobili.web.rest;

import com.cdv.mobili.service.HelloWorldServiceBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/helloWorld")
public class HelloWorldRESTService {

    @Inject
    private HelloWorldServiceBean helloWorldServiceBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String sayHello () {
        return helloWorldServiceBean.sayHello();
    }

}
