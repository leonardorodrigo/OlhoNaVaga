package br.com.olhonavaga.service;

import br.com.olhonavaga.model.Vaga;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 10:00
 */
public interface VagaServiceListener {

    void onSucesso(List<Vaga> vagas);

    void onError(Exception e);
}
