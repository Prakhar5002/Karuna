package com.Final.karuna;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SetArticlesData extends AsyncTask<String, Void, String> {

    Context context;

    public SetArticlesData(Context context){
        this.context = context;
    }
    @Override
    protected void onPreExecute() {
    }

    @Override
    protected String doInBackground(String... args) {
        String add_p_article_url = "http://192.168.43.45/Android/includes/addPhysicalArticles.php";
        String add_m_article_url = "http://192.168.43.45/Android/includes/addMentalArticles.php";
        String add_s_article_url = "http://192.168.43.45/Android/includes/addSpiritualArticles.php";

        String method = args[0];
        if (method.equals("physical_articles")){
            String p_title = args[1];
            String p_content = args[2];
            try {
                URL url = new URL(add_p_article_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("title", "UTF-8")+"="+URLEncoder.encode(p_title, "UTF-8")+"&"+
                        URLEncoder.encode("content", "UTF-8")+"="+URLEncoder.encode(p_content, "UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Physial Fitness Article Inserted successfully";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else if (method.equals("mental_articles")){
            String m_title = args[1];
            String m_content = args[2];
            try {
                URL url = new URL(add_m_article_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("title", "UTF-8")+"="+URLEncoder.encode(m_title, "UTF-8")+"&"+
                        URLEncoder.encode("content", "UTF-8")+"="+URLEncoder.encode(m_content, "UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Mental Fitness Article Inserted successfully";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (method.equals("spiritual_articles")){
            String s_title = args[1];
            String s_content = args[2];
            try {
                URL url = new URL(add_s_article_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));

                String data_string = URLEncoder.encode("title", "UTF-8")+"="+URLEncoder.encode(s_title, "UTF-8")+"&"+
                        URLEncoder.encode("content", "UTF-8")+"="+URLEncoder.encode(s_content, "UTF-8");
                bufferedWriter.write(data_string);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();
                return "Spiritual Fitness Article Inserted successfully";

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
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }
}

