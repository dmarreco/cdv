package com.cdv.mobili.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Stateless
//@Local(DaoService.class)
//@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DaoServiceBean implements DaoService
{
  @PersistenceContext
  private EntityManager em;

  public <T> T create(T t)
  {
    this.em.persist(t);
    this.em.flush();
    this.em.refresh(t);
    return t;
  }

  public <T> T find(Class<T> type, Long id)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public <T> T update(T t)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public void delete(Object t)
  {
    // TODO Auto-generated method stub

  }

  public List find(String queryName)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public List find(String queryName, int resultLimit)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public List find(String queryName, Map<String, Object> parameters)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public List find(String queryName, Map<String, Object> parameters, int resultLimit)
  {
    // TODO Auto-generated method stub
    return null;
  }

  public List findAll()
  {
    // TODO Auto-generated method stub
    return null;
  }

}
