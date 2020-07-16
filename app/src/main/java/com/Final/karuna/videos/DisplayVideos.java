package com.Final.karuna.videos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.Final.karuna.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class DisplayVideos extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<String> urlList = new ArrayList<String>();
    ArrayList<String> titleList = new ArrayList<String>();
    ArrayAdapter<String> arrayAdapter;
    RecyclerView recyclerView;



    class DownlaodTask extends AsyncTask<String, Void, String> implements MyAdapter.OnPressedListener {

        @Override
        protected String doInBackground(String... urls) {

            String result = "";
            try {
                URL url = new URL(urls[0]);
                HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
                urlConnection.connect();
                InputStream in = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(in);
                int data = reader.read();
                while(data!= -1){
                    char current = (char) data;
                    result += current;
                    data = reader.read();

                }
                return result;


            }catch (Exception e){
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray =jsonObject.getJSONArray("items");

                for(int i = 0; i< jsonArray.length()-1;i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i+1);
                    JSONObject jsonVideoId = jsonObject1.getJSONObject("id");
                    JSONObject jsonObjectSnippet = jsonObject1.getJSONObject("snippet");
                    JSONObject jsonObjectDefault = jsonObjectSnippet.getJSONObject("thumbnails").getJSONObject("medium");
                    String video_id = jsonVideoId.getString("videoId");
                    Log.i("video_id",video_id);



                    String url = jsonObjectDefault.getString("url");


                    urlList.add(i,url);

                    titleList.add(i,jsonObjectSnippet.getString("title"));
                    arrayList.add(i,video_id);

                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                recyclerView.setAdapter(new MyAdapter(urlList,titleList,arrayList, this));

            }catch (Exception e){


                e.printStackTrace();
            }
        }

        @Override
        public void onPress(int position) {
            Log.i("position",Integer.toString(position));
            Intent intent = new Intent(getApplicationContext(), VideoPlayer.class);
            intent.putExtra("videoId",arrayList.get(position));
            arrayList.get(position);
            startActivity(intent);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_videos);
        DownlaodTask downlaodTask = new DownlaodTask();
        recyclerView = findViewById(R.id.recyclerView);
        downlaodTask.execute("https://www.googleapis.com/youtube/v3/search?id=PL3xF4Pq4QywFCsvZp6FaUrb4bbpEXUDFi&channelId=UCxQilJGJOgQ4_ycYWoBU47g&key=AIzaSyA9DNv9c0r4J5bEGG-PlXj3rBvwqc-WzjI&part=snippet");
        Log.i("mssg","u reached here");
    }
}