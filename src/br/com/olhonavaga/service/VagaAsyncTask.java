package br.com.olhonavaga.service;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import br.com.olhonavaga.R;
import br.com.olhonavaga.model.Vaga;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 10:06
 */
public class VagaAsyncTask extends AsyncTask<VagaQueryParam, Void, List<Vaga>> {

    private VagaServiceListener listener;
    private VagaException exception;
    private ProgressDialog progressDialog;
    private Context context;

    public VagaAsyncTask(Context context, VagaServiceListener listener) {
        this.listener = listener;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.mensagem_aguarde));
        progressDialog.show();
    }

    @Override
    protected List<Vaga> doInBackground(VagaQueryParam... params) {
        VagaHttpRequest request = new VagaHttpRequest(params[0]);
        String json;
        try {
            json = request.getUrlResponse();
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonArray Jarray = parser.parse(json).getAsJsonArray();

            List<Vaga> vagas = new ArrayList<>();

            for (JsonElement obj : Jarray) {
                Vaga vaga = gson.fromJson(obj, Vaga.class);
                vagas.add(vaga);
            }
            return vagas;
        } catch (Exception e) {
            exception = new VagaException(e.getMessage());
            return new LinkedList<>();
        }
    }

    @Override
    protected void onPostExecute(List<Vaga> vagas) {
        super.onPostExecute(vagas);
        progressDialog.dismiss();
        if (listener != null && exception == null) {
            listener.onSucesso(vagas);
        }
        if (listener != null && exception != null) {
            listener.onError(exception);
        }
    }
}
