package com.cdv.mobili.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.NamedQuery;

import com.cdv.mobili.domain.EntidadeAbstrata;

/**
 *  Classe genérica para acesso a entidades persistidas.
 * 
 *  Realiza operações básicas de 
 *
 */
public interface DaoService
{
  
  /**
   * Persiste uma nova instância em banco.
   * 
   * @throws CheckedValidationException Caso não satisfaça algum validador definido na entidade
   */
  public <T extends EntidadeAbstrata> T create (T t) throws CheckedValidationException;
  
  /**
   * Obtém e retorna um objeto persistido em banco pela sua chave natural.
   * 
   * @param type A classe da entidade persistida
   * @param id Chave natural (id de banco) da entidade a ser obtida
   * @throws EntidadeInexistenteException Caso não exista uma entidade com o ID fornecido (o id é chave natural e nunca é informada pelo próprio usuário)
   */
  public <T extends EntidadeAbstrata> T find (Class<T> type, Long id);
  
  /**
   * Atualiza uma entidade que já foi persistida antes, sem alterar sua chave natural.
   * 
   * @throws CheckedValidationException Caso não satisfaça algum validador definido na entidade
   */
  public <T extends EntidadeAbstrata> T update (T t) throws CheckedValidationException;
  
  /**
   * Remove uma entidade já persistida, apagando os registro relacionados permanentemente.
   * 
   * @throws CheckedValidationException Caso com a remoção da entidade algum validador definido em outra entidade deixe de ser satisfeito
   */
  public <T extends EntidadeAbstrata> void delete (T t) throws CheckedValidationException;
  
  /**
   * Retorna uma lista de objetos de acordo com os critérios de uma Query que não recebe parâmetros.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   */
  public <T extends EntidadeAbstrata> List<T> findBy (String queryName);
  
  /**
   * Retorna uma lista de tamanho limitado de objetos de acordo com os critérios de uma Query que não recebe parâmetros.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   */
  public <T extends EntidadeAbstrata> List<T> findBy (String queryName, int resultLimit);
  
  /**
   * Retorna o primeiro objeto obtido de acordo com os critérios de uma Query que não recebe parâmetros.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   * @return O primeiro objeto retornado pela query ou NULL caso a query não retorne nenhum registro
   */
  public <T extends EntidadeAbstrata> T findFirstBy (String queryName);
  
  /**
   * Retorna uma lista de objetos de acordo com os critérios de uma Query parametrizada.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   * 
   * @see QueryParameter
   */
  public <T extends EntidadeAbstrata> List<T> findBy (String queryName, Map<String, Object> parameters);
  
  /**
   * Retorna uma lista de tamanho limitado de objetos de acordo com os critérios de uma Query parametrizada.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   * 
   * @see QueryParameter
   */
  public <T extends EntidadeAbstrata> List<T> findBy (String queryName, Map<String, Object> parameters, int resultLimit);
  
  /**
   * Retorna o primeiro objeto obtido de acordo com os critérios de uma Query parametrizada.
   * 
   * @param queryName Nome da {@link NamedQuery} a ser executada
   * @return O primeiro objeto retornado pela query ou NULL caso a query não retorne nenhum registro
   * 
   * @see QueryParameter
   */
  public <T extends EntidadeAbstrata> T findFirstBy (String queryName, Map<String, Object> parameters);
  
  /**
   * Lista TODAS as instâncias persistidas de um dado tipo.
   */
  public <T extends EntidadeAbstrata> List<T> findAll(Class<T> type);

  /**
   * Lista as primeiras instâncias persistidas de um dado tipo, ordenadas pela chave natural (ID).
   */
  public <T extends EntidadeAbstrata> List<T> findAll(Class<T> type, int resultLimit);
}
