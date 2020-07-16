package com.Final.karuna.home;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Final.karuna.AddAlarm;
import com.Final.karuna.GetArticlesData;
import com.Final.karuna.R;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainHomeFragment extends Fragment{

    Toolbar toolbar;
    RecyclerView phy_eng, phy_hin, men_eng, men_hin, sp_eng, sp_hin;
    private HomeAdapter ph_ad_en, ph_ad_hin, men_ad_en, men_ad_hin, sp_ad_en, sp_ad_hin;
    private ArrayList<HomeModel> m_ph_en, m_ph_hin, m_men_en, m_men_hin, m_sp_en, m_sp_hin;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.main_home_fragment, container, false);
        toolbar = view.findViewById(R.id.main_toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        phy_eng = view.findViewById(R.id.home_recycler_ph_eng);
        men_eng = view.findViewById(R.id.home_recycler_men_eng);
        sp_eng = view.findViewById(R.id.home_recycler_sp_eng);

        GetArticlesData getPhysicalEngData = new GetArticlesData(new GetArticlesData.ArticlesDataListener() {
            @Override
            public void getPhysicalArticles(String data) throws JSONException {
                JSONObject jsonObject = new JSONObject(data);
                final JSONArray jsonArray = jsonObject.getJSONArray("physical_articles_response");

                m_ph_en = new ArrayList<>();
                for (int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    HomeModel p_model_eng = new HomeModel(obj.getString("title"));
                    m_ph_en.add(p_model_eng);
                }
                HomeModel p1 = new HomeModel("Physical Article 1");
                HomeModel p2 = new HomeModel("Physical Article 2");
                HomeModel p3 = new HomeModel("Physical Article 3");
                HomeModel p4 = new HomeModel("Physical Article 4");
                HomeModel p5 = new HomeModel("Physical Article 5");
                m_ph_en.add(p1);
                m_ph_en.add(p2);
                m_ph_en.add(p3);
                m_ph_en.add(p4);
                m_ph_en.add(p5);

                phy_eng.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                ph_ad_en = new HomeAdapter(getContext(), m_ph_en);
                phy_eng.setHasFixedSize(true);
                phy_eng.setAdapter(ph_ad_en);
                ph_ad_en.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String TAG = "FullScreenDialog";
                        for (int i=0 ; i<jsonArray.length() ; i++)
                        {
                            try {
                                JSONObject check = jsonArray.getJSONObject(i);
                                if (m_ph_en.get(phy_eng.getChildAdapterPosition(v)).getTitle() == check.getString("title")){

                                    final Dialog dialog = new Dialog(getContext(), android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);;
                                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_full_screen, null);
                                    TextView title = dialogView.findViewById(R.id.fullscreen_dialog_title);
                                    TextView content = dialogView.findViewById(R.id.fullscreen_dialog_content);

                                    title.setText(m_ph_en.get(phy_eng.getChildAdapterPosition(v)).getTitle());
                                    content.setText(check.getString("content"));
                                    dialog.setContentView(dialogView);
                                    dialog.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
            }
        });
        getPhysicalEngData.execute("physical_fitness");

        GetArticlesData getMentalEngData = new GetArticlesData(new GetArticlesData.ArticlesDataListener() {
            @Override
            public void getPhysicalArticles(String data) throws JSONException {
                JSONObject jsonObject = new JSONObject(data);
                final JSONArray jsonArray = jsonObject.getJSONArray("mental_articles_response");

                m_men_en = new ArrayList<>();
                for (int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    HomeModel p_model_eng = new HomeModel(obj.getString("title"));
                    m_men_en.add(p_model_eng);
                }

                men_eng.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                men_ad_en = new HomeAdapter(getContext(), m_men_en);
                men_eng.setHasFixedSize(true);
                men_eng.setAdapter(men_ad_en);
                men_ad_en.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i=0 ; i<jsonArray.length() ; i++)
                        {
                            try {
                                JSONObject check = jsonArray.getJSONObject(i);
                                if (m_men_en.get(men_eng.getChildAdapterPosition(v)).getTitle() == check.getString("title")){

                                    final Dialog dialog = new Dialog(getContext(), android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
                                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_full_screen, null);
                                    TextView title = dialogView.findViewById(R.id.fullscreen_dialog_title);
                                    TextView content = dialogView.findViewById(R.id.fullscreen_dialog_content);

                                    title.setText(m_men_en.get(men_eng.getChildAdapterPosition(v)).getTitle());
                                    content.setText(check.getString("content"));
                                    dialog.setContentView(dialogView);
                                    dialog.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
            }
        });
        getMentalEngData.execute("mental_fitness");

        GetArticlesData getSpiritualEngData = new GetArticlesData(new GetArticlesData.ArticlesDataListener() {
            @Override
            public void getPhysicalArticles(String data) throws JSONException {
                JSONObject jsonObject = new JSONObject(data);
                final JSONArray jsonArray = jsonObject.getJSONArray("spiritual_articles_response");

                m_sp_en = new ArrayList<>();
                for (int i=0 ; i<jsonArray.length() ; i++){
                    JSONObject obj = jsonArray.getJSONObject(i);
                    HomeModel p_model_eng = new HomeModel(obj.getString("title"));
                    m_sp_en.add(p_model_eng);
                }

                sp_eng.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                sp_ad_en = new HomeAdapter(getContext(), m_sp_en);
                sp_eng.setHasFixedSize(true);
                sp_eng.setAdapter(sp_ad_en);
                sp_ad_en.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i=0 ; i<jsonArray.length() ; i++)
                        {
                            try {
                                JSONObject check = jsonArray.getJSONObject(i);
                                if (m_sp_en.get(sp_eng.getChildAdapterPosition(v)).getTitle() == check.getString("title")){

                                    final Dialog dialog = new Dialog(getContext(), android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
                                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_full_screen, null);
                                    TextView title = dialogView.findViewById(R.id.fullscreen_dialog_title);
                                    TextView content = dialogView.findViewById(R.id.fullscreen_dialog_content);

                                    title.setText(m_sp_en.get(sp_eng.getChildAdapterPosition(v)).getTitle());
                                    content.setText(check.getString("content"));
                                    dialog.setContentView(dialogView);
                                    dialog.show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                });
            }
        });
        getSpiritualEngData.execute("spiritual_fitness");
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.icon_add_alarm){
            Toast.makeText(getActivity(), "Add an alarm", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getContext(), AddAlarm.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
