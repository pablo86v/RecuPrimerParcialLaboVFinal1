package com.example.recuprimerparciallabovfinal1;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AutoViewHolder extends RecyclerView.ViewHolder{
    private MainActivity mainActivity;
    public TextView tvModelo;
    public TextView tvMarca;
    public AutoModel auto;
    public int position;

    public AutoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);

        this.mainActivity = mainActivity;
        tvModelo = itemView.findViewById(R.id.tvModelo);
        tvMarca = itemView.findViewById(R.id.tvMarca);


        itemView.findViewById(R.id.itemCard).setOnClickListener(new AutoListener(this, this.mainActivity));
    }


}

