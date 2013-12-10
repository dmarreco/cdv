package com.cdv.mobili.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.cdv.mobili.dao.DaoService;
import com.cdv.mobili.domain.Fornecedor;

/**
 * Serviço para prover funcionalidades da camada negócio  relacionadas ao caso de uso "Cadastro de Fornecedor"
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CadastroFornecedorService
{
  @Inject
  private DaoService dao;
  
  public Fornecedor cadastrar (Fornecedor fornecedor)  {
    return dao.create(fornecedor);
  }

    public List<Fornecedor> listarTodosFornecedores() {
        return dao.findAll(Fornecedor.class);
    }

}
