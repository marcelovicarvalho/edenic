package com.example.edenic;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonagensRecycler extends RecyclerView.Adapter<PersonagensRecycler.MyViewHolder> {

    ArrayList<String> nome = new ArrayList<>();
    ArrayList<String> nivel = new ArrayList<>();
    ArrayList<String> classe = new ArrayList<>();
    ArrayList<String> raca = new ArrayList<>();
    ArrayList<String> background = new ArrayList<>();
    Context context;

    public PersonagensRecycler(Context context, ArrayList<String> nome, ArrayList<String> nivel, ArrayList<String> classe, ArrayList<String> raca, ArrayList<String> background) {
        context = context;
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.raca = raca;
        this.background = background;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout txt = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_personagens, viewGroup, false);
        PersonagensRecycler.MyViewHolder myViewHolder = new PersonagensRecycler.MyViewHolder(txt);
//        Collections.sort(nome);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder Holder, int i) {
        Log.i("I", String.valueOf(i));
        Holder.nome.setText(nome.get(i));
        Holder.nivel.setText(nivel.get(i));
        Holder.classe.setText(classe.get(i));
        Holder.raca.setText(raca.get(i));
        Holder.background.setText(background.get(i));
    }

    @Override
    public int getItemCount()
    {
        Log.i("tamanho", String.valueOf(nome.size()));
        return nome.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nome;
        TextView nivel;
        TextView classe;
        TextView raca;
        TextView background;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome = itemView.findViewById(R.id.nome);
            nivel = itemView.findViewById(R.id.nivel);
            classe = itemView.findViewById(R.id.classe);
            raca = itemView.findViewById(R.id.raca);
            background = itemView.findViewById(R.id.background);
            cardView = itemView.findViewById(R.id.cardV2);
        }
    }

}
