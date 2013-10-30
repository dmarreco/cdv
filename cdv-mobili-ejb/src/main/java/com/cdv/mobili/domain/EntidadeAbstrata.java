package com.cdv.mobili.domain;

import java.io.Serializable;


/**
 * Classe das quais todas as entidades do sistema devem estender. <br/>
 * 
 * Ela � usada somente para prover implementa��es gen�ricas (e que podem ser sobrescritos em casos espec�ficos) 
 * dos m�todos hashCode, toString e equals. 
 */
public abstract class EntidadeAbstrata implements Serializable
{
  private static final long serialVersionUID = -3470420891522767118L;
  
  abstract public Long getId();

  /**
   * Implementa��o de equals() baseado no ID e no tipo.
   * 
   * @return <p><b>false</b>, caso:<ul>
   *            <li>(1) o objeto comparado seja null <b>OU</b>;</li>
   *            <li>(2) o tipo do objeto comparado n�o tenha rela��o hier�rquica com esse <b>OU</b>;</li>
   *            <li>(3) um dos objetos tenha id nulo</li></ul></p>
   *         <p><b>true</b>, caso:<ul>
   *            <li>(1) ambos objetos tenham id's n�o nulos e iguais e tenham conex�o hier�rquica <b>OU</b>;</li>
   *            <li>(2) ambos objetos tenham id's nulos e super.equals() retorne true;</li>
   */
  @Override
  public boolean equals(Object otherObj)  {
    if (otherObj == null 
        || !this.getClass().isInstance(otherObj.getClass()) 
        || !otherObj.getClass().isInstance(this.getClass()))    {
      return false;
    }
    
    EntidadeAbstrata otherEntity = (EntidadeAbstrata)otherObj;
    
    if (this.getId()!= null && otherEntity.getId() != null)    {
      return this.getId().equals(otherEntity.getId());
    }

    return super.equals(otherObj);
  }

  /**
   * Retorna hashcode baseado no ID
   * 
   * @return Caso o id seja nulo, o hashcode da superclasse; caso contr�rio, o hashcode do ID
   */
  @Override
  public int hashCode()  {
    if (this.getId()!= null)    {
      return this.getId().hashCode();
    } 
    return super.hashCode();
  }

  /**
   * Representa��o em formato String do objeto, baseado no seus ID e tipo
   * 
   * @return String no formato "[nome_da_classe]#[id_da_entidade]"
   */
  @Override
  public String toString()  {
    return this.getClass().getSimpleName() + "#" + getId();
  }
  
}
