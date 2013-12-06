package com.cdv.mobili.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.math.BigDecimal;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    @Size(min = 14, max = 14)
    @Digits(fraction = 0, integer = 14)
    @Column(length = 14)
    private String cnpj;

    @NotNull
    @NotEmpty
    @Column(name = "razao_social", length = 255)
    private String razaoSocial;

    @Column(name = "inscricao_estadual", length = 20)
    private String inscricaoEstadual;

    @Column(length = 255)
    private String endereco;

    @Column(length = 50)
    private String bairro;

    @Column(length = 50)
    private String cidade;

    @Pattern(regexp = "[A-Z]{2}")
    @Column(length = 2)
    private String uf;


    @Column(length = 9)
    private String cep;

    @Digits(fraction = 0, integer = 12)
    @Size(min = 10, max = 12)
    @Column(length = )
    private String fone1;
    private String fone2;
    private String fax;
    private String celular;
    private String nomeContato;

    @Email
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
