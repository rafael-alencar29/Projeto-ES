package com.example.ingressosonline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<Evento> eventos;

    public MyAdapter(Context c, ArrayList<Evento> event){

        context = c;
        eventos = event;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.lista_eventos,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.nome_apre.setText(eventos.get(i).getNome());
        myViewHolder.cod_apre.setText(eventos.get(i).getCodigoApresentacao());
        myViewHolder.data_apre.setText(eventos.get(i).getData());
        myViewHolder.Hora_apre.setText(eventos.get(i).getHorario());
        myViewHolder.preco_apre.setText(eventos.get(i).getPreco());
        myViewHolder.sala_apre.setText(eventos.get(i).getCodigoSala());
        myViewHolder.classe_apre.setText(eventos.get(i).getClasse());
        myViewHolder.faixa_apre.setText(eventos.get(i).getFaixa_etaria());
    }
    @Override
    public int getItemCount() {
        return eventos.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome_apre,cod_apre,data_apre,Hora_apre,preco_apre,sala_apre,
                classe_apre,faixa_apre;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            nome_apre = (TextView) itemView.findViewById(R.id.nome_apre);
            cod_apre = (TextView) itemView.findViewById(R.id.cod_apre);
            data_apre = (TextView) itemView.findViewById(R.id.data_apre);
            Hora_apre = (TextView) itemView.findViewById(R.id.Hora_apre);
            preco_apre = (TextView) itemView.findViewById(R.id.preco_apre);
            sala_apre = (TextView) itemView.findViewById(R.id.sala_apre);
            classe_apre = (TextView) itemView.findViewById(R.id.classe_apre);
            faixa_apre = (TextView) itemView.findViewById(R.id.faixa_apre);
        }
    }
}
