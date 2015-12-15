package br.com.olhonavaga.ui;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import br.com.olhonavaga.R;
import br.com.olhonavaga.model.Vaga;
import br.com.olhonavaga.service.VagaService;
import br.com.olhonavaga.service.VagaServiceImpl;
import br.com.olhonavaga.service.VagaServiceListener;

import java.util.List;

public class VagasListActivity extends ListActivity implements View.OnClickListener, VagaServiceListener {

    private EditText editTextPesquisaVagas;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vagas_list_activity);

        editTextPesquisaVagas = (EditText) findViewById(R.id.editText_pesquisa_vagas);
        findViewById(R.id.imageView_pesquisar).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (conexaoInternetAtiva()) {
            esconderTecladoVirtual();
            executarPesquisaVaga();
        } else {
            Toast.makeText(this, R.string.mensagem_sem_conexao_internet, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Vaga vaga = (Vaga) l.getAdapter().getItem(position);
        Intent intent = new Intent(this, DetalheVagaActivity.class);
        intent.putExtra(DetalheVagaActivity.EXTRAS_VAGA, vaga);
        startActivity(intent);
        super.onListItemClick(l, v, position, id);
    }

    private void executarPesquisaVaga() {
        VagaService service = new VagaServiceImpl();
        service.descricao(editTextPesquisaVagas.getText().toString()).procurar(this, this);
    }

    @Override
    public void onSucesso(List<Vaga> vagas) {
        VagaAdapter adapter = new VagaAdapter(vagas);
        getListView().setAdapter(adapter);
    }

    @Override
    public void onError(Exception e) {
        Toast.makeText(this, R.string.mensagem_erro_ao_procurar_vagas, Toast.LENGTH_LONG).show();
    }

    private void esconderTecladoVirtual() {
        View focus = this.getWindow().getCurrentFocus();
        if (focus != null) {
            ((InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(focus.getWindowToken(), 0);
        }
    }

    public boolean conexaoInternetAtiva() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeInfo = connMgr.getActiveNetworkInfo();
        if (activeInfo != null && activeInfo.isConnected()) {
            switch (activeInfo.getType()) {
                case ConnectivityManager.TYPE_DUMMY:
                    return false;
                case ConnectivityManager.TYPE_MOBILE:
                    return true;
                case ConnectivityManager.TYPE_BLUETOOTH:
                    return true;
                default:
                    return true;
            }
        }
        return false;
    }
}
