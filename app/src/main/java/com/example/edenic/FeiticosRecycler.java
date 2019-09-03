package com.example.edenic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FeiticosRecycler extends RecyclerView.Adapter<FeiticosRecycler.MyViewHolder> {

    ArrayList<String> spell_nome = new ArrayList<>();
    ArrayList<String> spell_nivel = new ArrayList<>();
    ArrayList<String> spell_cast_time = new ArrayList<>();
    ArrayList<String> spell_range = new ArrayList<>();
    final ArrayList<String> spell_components = new ArrayList<>();
    ArrayList<String> spell_duration = new ArrayList<>();
    ArrayList<String> spell_classe = new ArrayList<>();
    private int llLayout;
    private int layout1;

    public FeiticosRecycler(Context context, ArrayList<String>spell_nome,ArrayList<String>spell_nivel,ArrayList<String>spell_cast_time,ArrayList<String>spell_range,ArrayList<String>spell_duration,ArrayList<String>spell_classe){
        this.spell_nome = spell_nome;
        this.spell_nivel = spell_nivel;
        this.spell_cast_time = spell_cast_time;
        this.spell_range = spell_range;
        this.spell_duration = spell_duration;
        this.spell_classe = spell_classe;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LinearLayout txt = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(llLayout,viewGroup,false);
        FeiticosRecycler.MyViewHolder myViewHolder = new FeiticosRecycler.MyViewHolder(txt);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final FeiticosRecycler.MyViewHolder Holder, final int i){
        Holder.spell_nome.setText(spell_nome.get(i));
        Holder.spell_nivel.setText(spell_nivel.get(i));
        Holder.spell_cast_time.setText(spell_cast_time.get(i));
        Holder.spell_range.setText(spell_range.get(i));
        Holder.spell_classe.setText(spell_classe.get(i));

        Holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Deu certo maybe?");
            }
        });
    }

    @Override
    public int getItemCount() {  return spell_nome.size(); }
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView spell_nome;
        TextView spell_nivel;
        TextView spell_cast_time;
        TextView spell_range;
        TextView spell_classe;
        CardView cardView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            spell_nome = itemView.findViewById(R.id.nomeFeitico);
            spell_nivel = itemView.findViewById(R.id.nivelFeitico);
            spell_cast_time = itemView.findViewById(R.id.tempo);
            spell_range = itemView.findViewById(R.id.range);
            spell_classe = itemView.findViewById(R.id.classeFeitico);
            cardView = itemView.findViewById(R.id.cardV);
        }
    }

}
