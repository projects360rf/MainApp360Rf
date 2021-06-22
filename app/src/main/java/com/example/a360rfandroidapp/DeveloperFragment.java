package com.example.a360rfandroidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

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

public class DeveloperFragment extends Fragment {

    private ArrayList<DeveloperData> developerDataArrayList;
    private com.example.a360rfandroidapp.DeveloperAdapter developerAdapter;
    private RecyclerView devRV;
    private ProgressBar devPB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_developer, container, false);

        developerDataArrayList = new ArrayList<DeveloperData>();
        devRV = root.findViewById(R.id.developer_rv);
        devPB = root.findViewById(R.id.developer_pb);

        getDataFromAPI();
        return root;
    }

    private void getDataFromAPI() {
        String url = "https://spreadsheets.google.com/feeds/list/1sbn4i46ioufXP4SN2gXJApodw9GgeyiV_BPml2eQcrw/od6/public/values?alt=json";
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                devPB.setVisibility(View.GONE);
                Log.i("response",response.toString());
                try {
                    JSONObject feedObj = response.getJSONObject("feed");
                    JSONArray entryArray = feedObj.getJSONArray("entry");
                    for(int i=0; i<entryArray.length(); i++){
                        JSONObject entryObj = entryArray.getJSONObject(i);
                        String name = entryObj.getJSONObject("gsx$name").getString("$t");
                        String post = entryObj.getJSONObject("gsx$post").getString("$t");
                        String mail = entryObj.getJSONObject("gsx$mail").getString("$t");
                        String linkedin = entryObj.getJSONObject("gsx$linkedin").getString("$t");
                        String image = entryObj.getJSONObject("gsx$image").getString("$t");
                        developerDataArrayList.add(new com.example.a360rfandroidapp.DeveloperData(name, post, image, mail, linkedin));
                        developerAdapter = new com.example.a360rfandroidapp.DeveloperAdapter(developerDataArrayList, getActivity().getApplicationContext());
                        devRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                        devRV.setAdapter(developerAdapter);
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