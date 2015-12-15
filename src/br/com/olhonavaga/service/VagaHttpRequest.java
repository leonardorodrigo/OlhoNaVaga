package br.com.olhonavaga.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;


/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 10:10
 */
public class VagaHttpRequest {

    private VagaQueryParam queryParam;

    public VagaHttpRequest(VagaQueryParam queryParam) {
        this.queryParam = queryParam;
    }

    private String addURLParam() {
        String url = "";

        if (!queryParam.getDescription().isEmpty()) {
            url = formatarParametros(Parametros.DESCRICAO, queryParam.getDescription());
        }

        if (!queryParam.getLocation().isEmpty()) {
            url += formatarParametros(Parametros.LOCALIZACAO, queryParam.getLocation());
        }

        if (queryParam.isFullTime()) {
            url += formatarParametros(Parametros.TEMPO_INTEGRAL, "true");
        }

        return url;
    }

    private String formatarParametros(String parametro, String valor){
        return parametro + "=" + valor + "&";
    }

    public String getUrlResponse() throws Exception {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(Parametros.URI_BASE + addURLParam());
        HttpResponse response = httpclient.execute(httpGet);
        try {
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private static class Parametros {
        private static final String URI_BASE = "http://jobs.github.com/positions.json?";
        private static final String DESCRICAO = "description";
        private static final String LOCALIZACAO = "location";
        private static final String LATITUDE = "lat";
        private static final String LONGITUDE = "long";
        private static final String TEMPO_INTEGRAL = "full_time";
        private static final String PAGINA = "page";

    }
}
