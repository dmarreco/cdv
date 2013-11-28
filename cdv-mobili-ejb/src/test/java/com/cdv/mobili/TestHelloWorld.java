package com.cdv.mobili;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cdv.mobili.service.HelloWorldBean;

@RunWith(Arquillian.class)
public class TestHelloWorld
{
  @Deployment
  public static JavaArchive createTestArchive() {
      return ShrinkWrap.create(JavaArchive.class, "cdv-mobili-ejb-1.0.0-SNAPSHOT.jar")
              .addClass(HelloWorldBean.class)
              .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }
  
  @Inject
  private HelloWorldBean helloWorldService;
  
  @Test
  public void should_say_hello() {
    String obtained = helloWorldService.sayHello();
    
    assertEquals (obtained, "Hello, World!");
  }

}
