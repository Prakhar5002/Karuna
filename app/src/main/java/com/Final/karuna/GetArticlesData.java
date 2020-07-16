package com.Final.karuna;

import android.os.AsyncTask;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetArticlesData extends AsyncTask<String, Void, String> {

    public String p_url_eng, m_url_eng, s_url_eng, p_url_hin, m_url_hn, s_url_hin;
    String JSONStringPhysicalEng, JSONStringPhysicalHin, JSONStringMentalEng, JSONStringMentalHin, JSONStringSpiritualEng, JSONStringSpiritualalHin;

    public interface ArticlesDataListener{
        void getPhysicalArticles(String data) throws JSONException;
    }
    public ArticlesDataListener articlesDataListener = null;

    public GetArticlesData(ArticlesDataListener articlesDataListener){
        this.articlesDataListener = articlesDataListener;
    }

    @Override
    protected void onPreExecute() {
        p_url_eng = "http://192.168.43.45/Android/includes/getPhysicalFitnessData.php";
        m_url_eng = "http://192.168.43.45/Android/includes/getMentalFitnessData.php";
        s_url_eng = "http://192.168.43.45/Android/includes/getSpiritualFitnessData.php";
    }

    @Override
    protected String doInBackground(String... voids) {
        String method = voids[0];

        if (method.equals("physical_fitness")){
            try {
                URL url = new URL(p_url_eng);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSONStringPhysicalEng = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(JSONStringPhysicalEng+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("mental_fitness")){
            try {
                URL url = new URL(m_url_eng);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSONStringMentalEng = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(JSONStringMentalEng+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(method.equals("spiritual_fitness")){
            try {
                URL url = new URL(s_url_eng);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();
                while ((JSONStringSpiritualEng = bufferedReader.readLine()) != null)
                {
                    stringBuilder.append(JSONStringSpiritualEng+"\n");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  stringBuilder.toString().trim();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            articlesDataListener.getPhysicalArticles(result);
        } catch (JSONException e) {
            e.printStackTrace();
            return;
        }
    }
}

