package com.cdv.mobili.dao;

import javax.validation.ValidationException;

/**
 * Exceção checada, lançada pelo DAO quando há uma exceção de valida
 *
 */
public class CheckedValidationException extends Exception
{
  private static final long serialVersionUID = 2180711482778897441L;

  public CheckedValidationException (ValidationException cause) 
  {
    super (cause.getLocalizedMessage(), cause);
  }

}
