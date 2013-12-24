package com.cdv.mobili.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import org.slf4j.Logger;

import com.cdv.mobili.dao.CheckedValidationException;
import com.cdv.mobili.dao.DaoService;
import  static com.cdv.mobili.dao.QueryParameter.*;
import static com.cdv.mobili.domain.Fornecedor.*;
import com.cdv.mobili.domain.Fornecedor;
import com.cdv.mobili.exception.ApplicationBusinessException;

/**
 * Serviço para prover funcionalidades da camada negócio relacionadas ao caso de uso "Cadastro de Fornecedor"
 */
@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CadastroFornecedorService
{
  @EJB
  private DaoService dao;
  
  @Inject
  private Logger log;

  public Fornecedor cadastrar(Fornecedor fornecedor) throws ApplicationBusinessException
  {
    try {
      return dao.create(fornecedor);
    }
    catch (CheckedValidationException e)  {
      throw new ApplicationBusinessException(e);
    }
  }

  public List<Fornecedor> listarTodosFornecedores()
  {
    return dao.findAll(Fornecedor.class);
  }
  
  
  public Fornecedor obterFornecedorPorCnpj (String cnpj) 
  {
    List<Fornecedor> fornecedores = dao.findWithNamedQuery(findByCnpj, with("cnpj", cnpj).parameters());
    
    return (fornecedores.isEmpty() ? null : fornecedores.get(0));
  }

}
