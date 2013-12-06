package com.cdv.mobili.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Representa um Fornecedor de material
 *
 */
@Entity
@Table(name = "fornecedor")
public class Fornecedor extends EntidadeAbstrata
{
    private static final long serialVersionUID = 2995991452343344082L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 18, max = 18)
    @Pattern(regexp = "[0-9]{2}'.'[0-9]{3}'.'")
    private String cnpj;

    private String razaoSocial;
    private String inscricaoEstadual;
    private String endereco;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private String fone1;
    private String fone2;
    private String fax;
    private String celular;
    private String nomeContato;
    private String email;
    private String condicaoDePagamento;
    private BigDecimal percentualICMS;

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
