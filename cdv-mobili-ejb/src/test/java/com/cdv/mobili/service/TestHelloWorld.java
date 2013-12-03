package com.cdv.mobili.service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import com.cdv.mobili.domain.Fornecedor;
import com.cdv.mobili.service.HelloWorldServiceBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestHelloWorld
{
  @Deployment
  public static JavaArchive createTestArchive() {
      return ShrinkWrap.create(JavaArchive.class, "cdv-mobili-ejb.jar")
              .addClass(HelloWorldServiceBean.class)
              .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }
  
  @Inject
  private HelloWorldServiceBean helloWorldService;
  
  @Test
  public void should_say_hello() {
    String obtained = helloWorldService.sayHello();
    
    assertEquals (obtained, "Hello, World!");
  }

}