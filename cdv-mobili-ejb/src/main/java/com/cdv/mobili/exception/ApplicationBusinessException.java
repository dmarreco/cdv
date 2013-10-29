package com.cdv.mobili.exception;

import javax.ejb.ApplicationException;


/**
 * Classe gen�rica de exce��o lan�ada em caso de erro de neg�cio.
 * 
 * Pode ser estendida para erros espec�ficos
 */
@ApplicationException (rollback = false)
public class ApplicationBusinessException extends Exception
{
  private static final long serialVersionUID = 2187292844443549372L;
  
  public ApplicationBusinessException (String message) {
    super(message);
  }

}
