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
import javax.validation.ValidationException;

import com.cdv.mobili.domain.EntidadeAbstrata;

@Stateless
@Local(DaoService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DaoServiceBean implements DaoService
{
  @PersistenceContext
  private EntityManager em;

  @Override
  public <T extends EntidadeAbstrata> T create(T t) throws CheckedValidationException
  { 
    try {
      em.persist(t);
      em.flush();
      em.refresh(t);
      return t;
    }
    catch (ValidationException e) {
      throw new CheckedValidationException(e);
    }
  }

  @Override
  public <T extends EntidadeAbstrata> T find(Class<T> type, Long id)
  {
    T res = em.find(type, id);
    
    if (res == null)
      throw new EntidadeInexistenteException(type, id);
    
    return res;
  }

  @Override
  public <T extends EntidadeAbstrata> T update(T t) throws CheckedValidationException
  {
    try {
      T merged = em.merge(t);
      em.flush();
      return merged;
    }
    catch (ValidationException e) {
      throw new CheckedValidationException(e);
    }
  }

  @Override
  public <T extends EntidadeAbstrata> void delete(T t)
  {
    Object ref = em.getReference(t.getClass(), t);
    em.remove(ref);
    em.flush();
  }

  @Override
  public <T extends EntidadeAbstrata> List<T> findBy(String queryName)
  {
    return findBy(queryName, 0);
  }

  @Override
  public <T extends EntidadeAbstrata> List<T> findBy(String queryName, int resultLimit)
  {
    Query query = em.createNamedQuery(queryName);
    
    if (resultLimit > 0)
      query.setMaxResults(resultLimit);
    
    return query.getResultList();
  }
  
  @Override
  public <T extends EntidadeAbstrata> T findFirstBy(String queryName)
  {
    List<T> list = findBy(queryName, 1);
    
    return list.isEmpty() ? null : list.get(0);
  }

  @Override
  public <T extends EntidadeAbstrata> List<T> findBy(String queryName, Map<String, Object> parameters)
  {
    return findBy(queryName, parameters, 0);
  }
  
  @Override
  public <T extends EntidadeAbstrata> T findFirstBy(String queryName, Map<String, Object> parameters)
  {
    List<T> list = findBy(queryName, parameters, 1);
    
    return list.isEmpty() ? null : list.get(0);
  }

  @Override
  public <T extends EntidadeAbstrata> List<T> findBy(String queryName, Map<String, Object> parameters, int resultLimit)
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
  public <T extends EntidadeAbstrata> List<T> findAll(Class<T> type)
  {
    return findAll(type, 0);
  }

  @Override
  public <T extends EntidadeAbstrata> List<T> findAll(Class<T> type, int resultLimit)
  {
    String entityName = em.getMetamodel().entity(type).getName();
    Query q = em.createQuery("FROM " + entityName);
    return q.getResultList();
  }

}
