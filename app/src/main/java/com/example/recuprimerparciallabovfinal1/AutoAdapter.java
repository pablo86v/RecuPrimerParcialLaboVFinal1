package com.example.recuprimerparciallabovfinal1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;


public class AutoAdapter extends RecyclerView.Adapter<AutoViewHolder> {
    public List<AutoModel> listaAutos = new ArrayList<>();
    private MainActivity mainActivity;

    public AutoAdapter(List<AutoModel> listaAutos, MainActivity mainActivity) {
        this.listaAutos = listaAutos;
        this.mainActivity = mainActivity;
    }

    @NonNull
    @Override
    public AutoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Genero mi vista en memoria en base a mi layout customizado
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        AutoViewHolder autoViewHolder = new AutoViewHolder(v, this.mainActivity);
        return autoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AutoViewHolder holder, int position) {
        AutoModel auto = this.listaAutos.get(position);
        holder.position = position;
        holder.auto = auto;
        holder.tvModelo.setText(auto.getModel());
        holder.tvMarca.setText(auto.getMake());
    }

    @Override
    public int getItemCount() {
        return listaAutos.size();
    }
}