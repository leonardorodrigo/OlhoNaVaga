package br.com.olhonavaga.service;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 10:02
 */
public interface VagaService {

    VagaService descricao(String descricao);

    VagaService localizacao(String localizacao);

    VagaService latitude(double latitude);

    VagaService longitude(double longitude);

    void procurar(Context context, VagaServiceListener listener);
}
