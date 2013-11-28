package com.cdv.mobili.dao;

import java.util.List;
import java.util.Map;

public interface DaoService
{
  public <T> T create (T t);
  public <T> T find (Class<T> type, Long id);
  public <T> T update (T t);
  public void delete (Object t);
  public List findAll ();
  public List find (String queryName); 
  public List find (String queryName, int resultLimit);
  public List find (String queryName, Map<String, Object> parameters);
  public List find (String queryName, Map<String, Object> parameters, int resultLimit);
}
