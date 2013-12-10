package com.cdv.mobili.dao;

import java.util.List;
import java.util.Map;

public interface DaoService
{
  public <T> T create (T t);
  public <T> T find (Class<T> type, Long id);
  public <T> T update (T t);
  public <T> void delete (T t);
  public <T> List<T> findWithNamedQuery (String queryName); 
  public <T> List<T> findWithNamedQuery (String queryName, int resultLimit);
  public <T> List<T> findWithNamedQuery (String queryName, Map<String, Object> parameters);
  public <T> List<T> findWithNamedQuery (String queryName, Map<String, Object> parameters, int resultLimit);
  public <T> List<T> findAll(Class<T> type);
  public <T> List<T> findAll(Class<T> type, int resultLimit);
}
