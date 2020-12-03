package com.example.recuprimerparciallabovfinal1;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class HttpThread extends Thread {
    private Handler h;
    private String url;

    public HttpThread(Handler h, String urlParam) {
        this.h = h;
        this.url = urlParam;
    }

    @Override
    public void run() {
        super.run();

        HttpService c = new HttpService();
        String res = c.getData( this.url);

        Message m = new Message();
        m.obj = generarLista(res);
        h.sendMessage(m);
    }

    private List<AutoModel> generarLista(String res) {
        List<AutoModel> lista = new ArrayList<>();

        Log.d("res",res);

        try {
            JSONArray j = new JSONArray(res);
            for (int i = 0; i < j.length(); i++){
                JSONObject ob = j.getJSONObject(i);

                AutoModel auto = new AutoModel();
                auto.setMake(ob.getString("make"));
                auto.setModel(ob.getString("model"));

                lista.add(auto);
            }
            return lista;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}