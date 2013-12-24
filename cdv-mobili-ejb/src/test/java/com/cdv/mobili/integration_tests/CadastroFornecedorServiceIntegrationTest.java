package com.cdv.mobili.integration_tests;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.cdv.mobili.domain.Fornecedor;
import com.cdv.mobili.exception.ApplicationBusinessException;
import com.cdv.mobili.service.CadastroFornecedorService;


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
                        "com.cdv.mobili.exception",
                        "com.cdv.mobili.util",
                        "com.cdv.mobili.dao")
                .addAsResource("META-INF/persistence-test.xml", "META-INF/persistence.xml")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsManifestResource("cdv-mobili-test-ds.xml", "cdv-mobili-test-ds.xml");
    }

    @Inject
    private CadastroFornecedorService cadastroFornecedorService;

    @Test
    public void cadastrar_novo_fornecedor_com_sucesso () throws ApplicationBusinessException
    {
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setCnpj("60.701.190/0001-22");
        novoFornecedor.setRazaoSocial("CDV INDÚSTRIA E COMÉRCIO LTDA.");

        Fornecedor fornecedorCriado = cadastroFornecedorService.cadastrar(novoFornecedor);

        /* O ID é gerado automaticamente pelo banco (auto increment/sequence) ao persistir */
        assertNotNull(fornecedorCriado.getId());
    }

    @Test(expected = ApplicationBusinessException.class)
    public void cadastrar_novo_fornecedor_sem_cnpj_gera_erro_de_validacao () throws ApplicationBusinessException
    {
        Fornecedor novoFornecedor = new Fornecedor();
        novoFornecedor.setRazaoSocial("CDV INDÚSTRIA E COMÉRCIO LTDA.");

        Fornecedor fornecedorCriado = cadastroFornecedorService.cadastrar(novoFornecedor);
    }

}
