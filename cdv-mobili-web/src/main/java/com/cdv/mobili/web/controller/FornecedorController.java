package com.cdv.mobili.web.controller;


import com.cdv.mobili.domain.Fornecedor;
import com.cdv.mobili.exception.ApplicationBusinessException;
import com.cdv.mobili.service.CadastroFornecedorService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import java.util.List;

/**
 * Controlador para funcionalidades da camada de apresentação relacionadas ao caso de uso "Cadastro de Fornecedor"
 */
/* The @Model stereotype is a convenience mechanism to make this a request-scoped bean that has an EL name */
@Model
@RequestScoped
public class FornecedorController {

    @Inject
    private FacesContext facesContext;

    @Inject
    private CadastroFornecedorService cadastroFornecedorService;

    private Fornecedor novoFornecedor;

    private List<Fornecedor> fornecedores;

    @PostConstruct
    public void init () {
        this.novoFornecedor = new Fornecedor();
        refreshFornecedorList();
    }

    @Produces
    @Named
    public Fornecedor getNovoFornecedor () {
        return novoFornecedor;
    }

    @Produces
    @Named
    public List<Fornecedor> getFornecedores () {
        return fornecedores;
    }

    public void onFornecedorListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Fornecedor fornecedor) {
        refreshFornecedorList();
    }

    public void cadastrar() throws Exception {
        try {
            cadastroFornecedorService.cadastrar(novoFornecedor);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado!", "Fornecedor cadastrado com sucesso!"));
            init();
        } 
        catch (ApplicationBusinessException e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), "Falha ao cadastrar");
            facesContext.addMessage(null, m);
        }
    }

    private void refreshFornecedorList () {
        this.fornecedores = cadastroFornecedorService.listarTodosFornecedores();
    }

}
