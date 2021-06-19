package com.example.a360rfandroidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

public class DepartmentFragment extends Fragment {
    private ArrayList<DepartmentData> departmentDataArrayList;
    private DepartmentAdapter departmentAdapter;
    private RecyclerView deptRV;
    private ProgressBar loadingPB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root;
        root = inflater.inflate(R.layout.fragment_department, container, false);

        departmentDataArrayList = new ArrayList<>();
        deptRV = root.findViewById(R.id.deptRV_department);
        loadingPB = root.findViewById(R.id.idPBLoading_department);
        getDataFromAPI();

        return root;
    }

    private void getDataFromAPI() {
        String url = "https://spreadsheets.google.com/feeds/list/1ybvdYoXChKW-kRpw7SdEJq_sjLb9Z9E2mUc_fweIjrI/od6/public/values?alt=json";
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
                        String image = entryObj.getJSONObject("gsx$image").getString("$t");
                        departmentDataArrayList.add(new DepartmentData(name, description, image));
                        departmentAdapter = new DepartmentAdapter(departmentDataArrayList, getActivity().getApplicationContext());
                        deptRV.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
                        deptRV.setAdapter(departmentAdapter);
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
