package com.example.a360rfandroidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class NewsFragment extends Fragment {
    private ArrayList<com.example.a360rfandroidapp.NewsData> newsDataArrayList;
    private com.example.a360rfandroidapp.NewsAdapter newsAdapter;
    private RecyclerView newsRV;
    private ProgressBar loadingPB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root;
        root= inflater.inflate(R.layout.fragment_news, container, false);
        newsDataArrayList = new ArrayList<>();
        newsRV = root.findViewById(R.id.newsRV);
        loadingPB = root.findViewById(R.id.idPBLoading);
        getDataFromAPI();
        return root;
    }

    private void getDataFromAPI() {
        String url = "https://spreadsheets.google.com/feeds/list/1Gm0ydJTfzDavsujW8qN84IAL4v64SJExGS6lpn7pwgM/od6/public/values?alt=json";
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loadingPB.setVisibility(View.GONE);
                Log.i("response",response.toString());
                try {
                    JSONObject feedObj = response.getJSONObject("feed");
                    JSONArray entryArray = feedObj.getJSONArray("entry");
                    for(int i=0; i<entryArray.length(); i++){
                        JSONObject entryObj = entryArray.getJSONObject(i);
                        String name = entryObj.getJSONObject("gsx$name").getString("$t");
                        String description = entryObj.getJSONObject("gsx$description").getString("$t");
                        String date = entryObj.getJSONObject("gsx$date").getString("$t");
                        String image = entryObj.getJSONObject("gsx$image").getString("$t");
                        newsDataArrayList.add(new com.example.a360rfandroidapp.NewsData(name, description, date, image));
                        newsAdapter = new com.example.a360rfandroidapp.NewsAdapter(newsDataArrayList, getActivity().getApplicationContext());
                        newsRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                        newsRV.setAdapter(newsAdapter);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), "Fail to get data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}