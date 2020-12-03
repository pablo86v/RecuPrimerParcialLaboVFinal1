package com.example.recuprimerparciallabovfinal1;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    EditText etModelo;
    EditText etMarca;
    Bundle bundle;
    AutoModel auto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getString(R.string.detail_title));
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        bundle = i.getExtras();
        auto = (AutoModel) bundle.getSerializable("AutoModel");

        etModelo = (EditText)super.findViewById(R.id.etModelo);
        etMarca = (EditText)super.findViewById(R.id.etMarca);

        etMarca.setText(auto.getMake());
        etModelo.setText(auto.getModel());

        Button btnEditar = (Button)super.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auto.setMake(etMarca.getText().toString());
                auto.setModel(etModelo.getText().toString());

                Intent returnIntent = new Intent();
                returnIntent.putExtra("position", bundle.getInt("position"));
                returnIntent.putExtra("AutoModel", auto);

                setResult(DetailActivity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if(menuItem.getItemId() == android.R.id.home){
            Intent mainActivity = new Intent(this, MainActivity.class);
            mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
        return (super.onOptionsItemSelected(menuItem));
    }
}