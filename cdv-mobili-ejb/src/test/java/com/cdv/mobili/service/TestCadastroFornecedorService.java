package com.cdv.mobili.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

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
@Ignore
public class TestCadastroFornecedorService
{
  @Inject
  private CadastroFornecedorService cadastroFornecedorService;
  
  @Deployment
  public static JavaArchive createTestArchive() {
      return ShrinkWrap.create(JavaArchive.class, "cdv-mobili-ejb-1.0.0-SNAPSHOT.jar")
              .addPackages(true, "com.cdv.mobili.service")
              .addAsManifestResource("persistence-test.xml", "persistence.xml")
              .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  }
  
  @Test
  public void cadastraNovoFornecedorComSucesso ()
  {
    Fornecedor novoFornecedor = new Fornecedor();
    novoFornecedor.setCnpj("60701190/0001-22");
    
    Fornecedor fornecedorCriado = cadastroFornecedorService.create(novoFornecedor);
    
    assertNotNull(fornecedorCriado.getId());
  }

}
