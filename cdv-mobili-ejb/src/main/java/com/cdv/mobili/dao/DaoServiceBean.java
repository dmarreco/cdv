package com.cdv.mobili.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@Local(DaoService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DaoServiceBean implements DaoService
{
  @PersistenceContext
  private EntityManager em;

  @Override
  public <T> T create(T t)
  {
    em.persist(t);
    em.flush();
    em.refresh(t);
    return t;
  }

  @Override
  public <T> T find(Class<T> type, Long id)
  {
    return em.find(type, id);
  }

  @Override
  public <T> T update(T t)
  {
    return em.merge(t);
  }

  @Override
  public <T> void delete(T t)
  {
    Object ref = em.getReference(t.getClass(), t);
    em.remove(ref);
  }

  @Override
  public <T> List<T> findWithNamedQuery(String queryName)
  {
    return findWithNamedQuery(queryName, 0);
  }

  @Override
  public <T> List<T> findWithNamedQuery(String queryName, int resultLimit)
  {
    Query query = em.createNamedQuery(queryName);
    
    if (resultLimit > 0)
      query.setMaxResults(resultLimit);
    
    return query.getResultList();
  }

  @Override
  public <T> List<T> findWithNamedQuery(String queryName, Map<String, Object> parameters)
  {
    return findWithNamedQuery(queryName, parameters, 0);
  }

  @Override
  public <T> List<T> findWithNamedQuery(String queryName, Map<String, Object> parameters, int resultLimit)
  {
    Query query = em.createNamedQuery(queryName);
    
    if (resultLimit > 0) 
      query.setMaxResults(resultLimit);
    
    for (Entry<String, Object> entry : parameters.entrySet()) {
      query.setParameter(entry.getKey(), entry.getValue());
    }
    
    return query.getResultList();
  }

  @Override
  public <T> List<T> findAll(Class<T> type)
  {
    return findAll(type, 0);
  }

  @Override
  public <T> List<T> findAll(Class<T> type, int resultLimit)
  {
    String entityName = em.getMetamodel().entity(type).getName();
    Query q = em.createQuery("FROM " + entityName);
    return q.getResultList();
  }

}
