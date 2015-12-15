package br.com.olhonavaga.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.olhonavaga.R;
import br.com.olhonavaga.model.Vaga;
import com.squareup.picasso.Picasso;


/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 11:10
 */
public class DetalheVagaActivity extends FragmentActivity {

    public static final String EXTRAS_VAGA = "vaga";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detalhe_vaga_activity);

        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setDisplayShowHomeEnabled(true);

        Vaga vaga = (Vaga) getIntent().getSerializableExtra(EXTRAS_VAGA);

        TextView textviewTitulo = (TextView) findViewById(R.id.textView_titulo);
        TextView textviewEmpresa = (TextView) findViewById(R.id.textView_empresa);
        TextView textviewLocalizacao = (TextView) findViewById(R.id.textView_localizacao);
        ImageView imageviewLogo = (ImageView) findViewById(R.id.imageView_logo);
        WebView webviewDescricao = (WebView) findViewById(R.id.webView_descricao);

        textviewTitulo.setText(vaga.getTitle());
        textviewEmpresa.setText(vaga.getCompany());
        textviewLocalizacao.setText(vaga.getLocation());
        webviewDescricao.loadData(vaga.getDescription(), "text/html", "UTF-8");
        Picasso.with(this).load(vaga.getCompanyLogo()).into(imageviewLogo);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}