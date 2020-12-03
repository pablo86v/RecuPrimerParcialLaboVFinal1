package com.example.recuprimerparciallabovfinal1;
import android.content.Intent;
import android.view.View;

public class AutoListener implements View.OnClickListener {
    private MainActivity mainActivity;
    private AutoViewHolder autoViewHolder;


    public AutoListener(AutoViewHolder autoViewHolder, MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.autoViewHolder = autoViewHolder;
    }

    @Override
    public void onClick(View view){
        AutoModel auto = this.autoViewHolder.auto;
        Intent i = new Intent(this.mainActivity, DetailActivity.class);
        i.putExtra("position", this.autoViewHolder.position);
        i.putExtra("AutoModel", auto);

        mainActivity.startActivityForResult(i,1);
    }
}