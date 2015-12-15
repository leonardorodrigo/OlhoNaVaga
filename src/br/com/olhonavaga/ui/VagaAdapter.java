package br.com.olhonavaga.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.olhonavaga.R;
import br.com.olhonavaga.model.Vaga;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 09:37
 */
public class VagaAdapter extends BaseAdapter {

    private List<Vaga> vagas;

    public VagaAdapter(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    @Override
    public int getCount() {
        return vagas.size();
    }

    @Override
    public Vaga getItem(int position) {
        return vagas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vaga_adapter, null);
        }

        Vaga vaga = vagas.get(position);

        ((TextView) convertView.findViewById(R.id.textView_titulo)).setText(vaga.getTitle());
        ((TextView) convertView.findViewById(R.id.textView_empresa)).setText(vaga.getCompany());
        ((TextView) convertView.findViewById(R.id.textView_localizacao)).setText(vaga.getLocation());
        ((TextView) convertView.findViewById(R.id.textView_data_publicacao)).setText(vaga.getCreatedAt());

        return convertView;
    }
}
