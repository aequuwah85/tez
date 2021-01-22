package org.tensorflow.lite.examples.detection;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder>{
    String languages[];
    Context context;


    public Myadapter(Context ct,String s1[]){
        this.context=ct;
        languages=s1;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.language_row,parent,false);
        return new  MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.languageText.setText(languages[position]);
        holder.myRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent ( context, DetectorActivity.class);
                intent.putExtra("language",languages[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return languages.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView languageText;
        RelativeLayout myRow;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            languageText=itemView.findViewById(R.id.languageText);
            myRow = itemView.findViewById(R.id.myRow);
        }
    }
}
