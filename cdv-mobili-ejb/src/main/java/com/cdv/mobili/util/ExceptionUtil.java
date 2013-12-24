package com.cdv.mobili.util;

public class ExceptionUtil
{

  private static Throwable getRootCause(Exception e) 
  {
    Throwable t = e;
    while (t != null) {
        t = t.getCause();
    }
    return t;
  }

  
}
