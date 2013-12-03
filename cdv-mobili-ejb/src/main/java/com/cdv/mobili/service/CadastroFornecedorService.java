package com.cdv.mobili.service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.cdv.mobili.dao.DaoService;
import com.cdv.mobili.domain.Fornecedor;

@Stateless
//@LocalBean
//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CadastroFornecedorService
{
  @Inject
  private DaoService dao;
  
  public Fornecedor create (Fornecedor fornecedor)  {
    return dao.create(fornecedor);
  }
}
