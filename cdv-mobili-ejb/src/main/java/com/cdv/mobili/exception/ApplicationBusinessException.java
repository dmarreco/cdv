package com.cdv.mobili.exception;

import javax.ejb.ApplicationException;


/**
 * Classe genérica de exceção lançada em caso de erro de negócio.
 * 
 * Pode ser estendida para erros específicos
 */
@ApplicationException (rollback = false)
public class ApplicationBusinessException extends Exception
{
  private static final long serialVersionUID = 2187292844443549372L;
  
  public ApplicationBusinessException (String message) {
    super (message);
  }
  
  public ApplicationBusinessException (String message, Throwable cause) {
    super (message, cause);
  }
  
  public ApplicationBusinessException (Throwable cause) {
    super (cause.getLocalizedMessage(), cause);
  }

}
