package br.com.olhonavaga.service;

import android.content.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 10:04
 */
public class VagaServiceImpl implements VagaService {

    private VagaQueryParam queryParam;

    public VagaServiceImpl() {
        queryParam = new VagaQueryParam();
    }

    @Override
    public VagaService descricao(String descricao) {
        queryParam.setDescription(descricao);
        return this;
    }

    @Override
    public VagaService localizacao(String localizacao) {
        queryParam.setLocation(localizacao);
        return this;
    }

    @Override
    public VagaService latitude(double latitude) {
        queryParam.setLat(latitude);
        return this;
    }

    @Override
    public VagaService longitude(double longitude) {
        queryParam.setLon(longitude);
        return this;
    }

    @Override
    public void procurar(Context context, VagaServiceListener listener) {
        VagaAsyncTask asyncTask = new VagaAsyncTask(context, listener);
        asyncTask.execute(queryParam);
    }
}
