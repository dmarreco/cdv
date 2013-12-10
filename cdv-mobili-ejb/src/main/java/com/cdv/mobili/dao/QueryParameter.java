package com.cdv.mobili.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * Builder para parâmetros de queries.<br/><br/>
 * 
 * Exemplo de uso:<br/>
 * 
 * <i>
 * daoService.findWithNamedQuery("findByLoginESenha", 
 *  with("login", login)
 *  .and("senha", senha)
 *  .parameters());
 * </i>
 *
 */
public class QueryParameter
{
  private Map<String, Object> parameters = null;
  
  private QueryParameter (String name, Object value)
  {
    parameters = new HashMap<String, Object>();
    parameters.put(name, value);
  }
  
  public static QueryParameter with (String name, Object value)
  {
    return new QueryParameter(name, value);
  }
  
  public QueryParameter and(String name, Object value)
  {
    parameters.put(name, value); 
    //TODO Lança NullPointerException se QueryParameter.with não tiver sido chamado primeiro. Lançar uma Exception específica? 
    return this;
  }
  
  public Map<String, Object> parameters ()
  {
    return parameters;
  }
}
