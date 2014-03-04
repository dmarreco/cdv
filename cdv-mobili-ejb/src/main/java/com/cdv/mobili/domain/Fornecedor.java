package com.cdv.mobili.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Representa um Fornecedor de material
 *
 */
@Entity
@Table(name = "Fornecedor")
@NamedQueries({
  @NamedQuery(name = Fornecedor.findByCnpj, query = "FROM Fornecedor f WHERE f.cnpj = :cnpj")
})
public class Fornecedor extends EntidadeAbstrata
{
    private static final long serialVersionUID = 2995991452343344082L;
    
    public static final String PREFIX = "Fornecedor."; 
    public static final String findByCnpj = PREFIX + "findByCnpj";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 14, max = 18)
    @Pattern(regexp =  "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}\\/[0-9]{4}\\-[0-9]{2}")
    @Column(length = 18, unique = true)
    private String cnpj;

    @NotNull
    @NotEmpty
    @Column(name = "razao_social", length = 255)
    private String razaoSocial;

    @Column(name = "inscricao_estadual", length = 20)
    private String inscricaoEstadual;

    @Size (max = 255)
    @Column(length = 255)
    private String endereco;

    @Size (max = 50)
    @Column(length = 50)
    private String bairro;

    @Size (max = 50)
    @Column(length = 50)
    private String cidade;

    @Pattern(regexp = "[A-Z]{2}")
    @Column(length = 2)
    private String uf;

    @Pattern(regexp = "[0-9]{5}\\-[0-9]{3}")
    @Column(length = 9)
    private String cep;

    @Digits(fraction = 0, integer = 12)
    @Size(min = 10, max = 12)
    @Column(length = 12)
    private String fone1;

    @Digits(fraction = 0, integer = 12)
    @Size(min = 10, max = 12)
    @Column(length = 12)
    private String fone2;

    @Digits(fraction = 0, integer = 12)
    @Size(min = 10, max = 12)
    @Column(length = 12)
    private String fax;

    @Digits(fraction = 0, integer = 12)
    @Size(min = 10, max = 12)
    @Column(length = 12)
    private String celular;

    @Column(name = "nome_contato", length = 255)
    private String nomeContato;

    @Email
    @Column(length = 150)
    private String email;

    @Column(name = "condicao_pgto", length = 255)
    private String condicaoDePagamento;

    @Digits(fraction = 2, integer = 2)
    private BigDecimal percentualICMS;


    /*
     * Getters / Setters
     */

    public Long getId()  {
        return id;
    }
    public void setId(Long id)  {
        this.id = id;
    }

    public String getCnpj()  {
        return cnpj;
    }
    public void setCnpj(String cnpj)  {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial()  {
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial)  {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual()  {
        return inscricaoEstadual;
    }
    public void setInscricaoEstadual(String inscricaoEstadual)  {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getEndereco()  {
        return endereco;
    }
    public void setEndereco(String endereco)  {
        this.endereco = endereco;
    }

    public String getBairro()  {
        return bairro;
    }
    public void setBairro(String bairro)  {
        this.bairro = bairro;
    }

    public String getCidade()  {
        return cidade;
    }
    public void setCidade(String cidade)  {
        this.cidade = cidade;
    }

    public String getUf()  {
        return uf;
    }
    public void setUf(String uf)  {
        this.uf = uf;
    }

    public String getCep()  {
        return cep;
    }
    public void setCep(String cep)  {
        this.cep = cep;
    }

    public String getFone1()  {
        return fone1;
    }
    public void setFone1(String fone1)  {
        this.fone1 = fone1;
    }

    public String getFone2()  {
        return fone2;
    }
    public void setFone2(String fone2)  {
        this.fone2 = fone2;
    }

    public String getFax()  {
        return fax;
    }
    public void setFax(String fax)  {
        this.fax = fax;
    }

    public String getCelular()  {
        return celular;
    }
    public void setCelular(String celular)  {
        this.celular = celular;
    }

    public String getNomeContato()  {
        return nomeContato;
    }
    public void setNomeContato(String nomeContato)  {
        this.nomeContato = nomeContato;
    }

    public String getEmail()  {
        return email;
    }
    public void setEmail(String email)  {
        this.email = email;
    }

    public String getCondicaoDePagamento()  {
        return condicaoDePagamento;
    }
    public void setCondicaoDePagamento(String condicaoDePagamento)  {
        this.condicaoDePagamento = condicaoDePagamento;
    }

    public BigDecimal getPercentualICMS()  {
        return percentualICMS;
    }
    public void setPercentualICMS(BigDecimal percentualICMS)  {
        this.percentualICMS = percentualICMS;
    }


}
