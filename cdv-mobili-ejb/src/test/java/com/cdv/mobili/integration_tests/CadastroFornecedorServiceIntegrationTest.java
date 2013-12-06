package com.cdv.mobili.integration_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.inject.Inject;
import javax.validation.Constraint;
import javax.validation.ConstraintViolationException;

import com.cdv.mobili.service.CadastroFornecedorService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cdv.mobili.domain.Fornecedor;


@RunWith(Arquillian.class)
public class CadastroFornecedorServiceIntegrationTest
{
    @Deployment
    public static JavaArchive createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "cdv-mobili-ejb.jar")
                .addClass(CadastroFornecedorService.class)
                .addPackages(true,
                        "com.cdv.mobili.domain",
                        "com.cdv.mobili.service",
                        "com.cdv.mobili.dao")
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("cdv-mobili-test-ds.xml", "cdv-mobili-test-ds.xml");
    }

    @Inject
    private CadastroFornecedorService cadastroFornecedorService;

    @Test
    public void cadastrar_novo_fornecedor_com_sucesso ()
    {
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setCnpj("60.701.190/0001-22");
        novoFornecedor.setRazaoSocial("CDV INDÚSTRIA E COMÉRCIO LTDA.");

        Fornecedor fornecedorCriado = cadastroFornecedorService.create(novoFornecedor);

        /* O ID é gerado automaticamente pelo banco (auto increment/sequence) ao persistir */
        assertNotNull(fornecedorCriado.getId());
    }

    @Test(expected = Exception.class)
    public void cadastrar_novo_fornecedor_sem_cnpj_gera_erro_de_validacao () throws InterruptedException
    {
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setRazaoSocial("CDV INDÚSTRIA E COMÉRCIO LTDA.");

        Fornecedor fornecedorCriado = cadastroFornecedorService.create(novoFornecedor);
    }

}
