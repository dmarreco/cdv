package com.cdv.mobili.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import com.cdv.mobili.domain.EntidadeAbstrata;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cdv.mobili.domain.Fornecedor;


@RunWith(Arquillian.class)
public class TestCadastroFornecedorService
{
  @Deployment
  public static JavaArchive createTestArchive() {
      return ShrinkWrap.create(JavaArchive.class, "cdv-mobili-ejb.jar")
              .addClass(CadastroFornecedorService.class)
              .addClass(HelloWorldServiceBean.class)
              .addPackages(true, "com.cdv.mobili.domain",
                                 "com.cdv.mobili.service",
                                 "com.cdv.mobili.dao")
              .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
              .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
              .addAsManifestResource("cdv-mobili-test-ds.xml", "cdv-mobili-test-ds.xml");
  }

    @Inject
    private CadastroFornecedorService cadastroFornecedorService;

    @Inject
    private HelloWorldServiceBean helloWorldService;
  
  @Test
  public void cadastraNovoFornecedorComSucesso ()
  {
    Fornecedor novoFornecedor = new Fornecedor();
    novoFornecedor.setCnpj("60701190/0001-22");
    
    Fornecedor fornecedorCriado = cadastroFornecedorService.create(novoFornecedor);
    
    assertNotNull(fornecedorCriado.getId());
  }

    @Test
    public void should_say_hello() {
        String obtained = helloWorldService.sayHello();

        assertEquals (obtained, "Hello, World!");
    }

}
