package com.cdv.mobili.dao;

/**
 * Lançado ao tentar obter uma entidade através de sua chave natural (ID) mas ela não existe. 
 *
 */
public class EntidadeInexistenteException extends RuntimeException
{
  private static final long serialVersionUID = -4250956735515836916L;
  
  public EntidadeInexistenteException (Class type, Long id) {
    super("Erro tentando recuperar entidade inexistente [Type=" + type + "; Id=" + id + "]");
  }

}
