package com.example.a360rfandroidapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.a360rfandroidapp.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class ContactFragment extends Fragment {

    TextInputEditText nameEt,emailEt,phoneEt,subjectEt,messageEt,placeEt;
    Button sendMsg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);

        nameEt=root.findViewById(R.id.name);
        emailEt=root.findViewById(R.id.email);
        phoneEt=root.findViewById(R.id.phone);
        subjectEt=root.findViewById(R.id.subject);
        messageEt=root.findViewById(R.id.message);
        sendMsg=root.findViewById(R.id.sendMsg);
        placeEt=root.findViewById(R.id.place);
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar_1);
        //toolbar.setTitle("Contact Us");
        final RelativeLayout progressLayout=root.findViewById(R.id.progressLayout);
        final CardView formLayout=root.findViewById(R.id.form);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = nameEt.getText().toString().trim();
                final String email = emailEt.getText().toString().trim();
                final String phone = phoneEt.getText().toString().trim();
                final String subject = subjectEt.getText().toString().trim();
                final String message = messageEt.getText().toString().trim();
                final String place=placeEt.getText().toString().trim();
                if (name.equals("")) {
                    nameEt.setError("Name cannot be empty");
                } else if (email.equals("")) {
                    emailEt.setError("E-mail cannot be empty");
                } else if (phone.equals("")) {
                    phoneEt.setError("Phone number cannot be empty");
                } else if (subject.equals("")) {
                    subjectEt.setError("Subject cannot be empty");
                } else if (message.equals("")) {
                    messageEt.setError("Message cannot be empty");
                } else if (place.equals("")) {
                    placeEt.setError("Place cannot be empty");
                } else if (phone.length() != 10) {
                    phoneEt.setError("Invalid Number");
                } else {
                    progressLayout.setVisibility(View.VISIBLE);
                    formLayout.setVisibility(View.INVISIBLE);
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbxpSYC3Gq3TGWgJYzBALQXiWcKvONBSZFjrWjmjmZ0_lID2rkub/exec", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Success")) {
                                nameEt.setText("");
                                emailEt.setText("");
                                phoneEt.setText("");
                                messageEt.setText("");
                                subjectEt.setText("");
                                placeEt.setText("");
                                progressLayout.setVisibility(View.INVISIBLE);
                                formLayout.setVisibility(View.VISIBLE);
                                Log.i("message", response);
                                View view=root.getRootView();
                                Snackbar snackbar=Snackbar.make(view,"SENT",Snackbar.LENGTH_INDEFINITE);
                                snackbar.setAction("OKAY", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        snackbar.dismiss();
                                    }
                                });
                                snackbar.show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressLayout.setVisibility(View.INVISIBLE);
                            formLayout.setVisibility(View.VISIBLE);
                            Toast.makeText(getActivity().getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
                            Log.i("ErrorMsg", error.toString());
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<>();
                            params.put("action", "addItem");
                            params.put("name", name);
                            params.put("email", email);
                            params.put("phone", phone);
                            params.put("subject", subject);
                            params.put("message", message);
                            params.put("place", place);
                            return params;
                        }
                    };
                    int socketTimeOut = 50000;
                    RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
                    stringRequest.setRetryPolicy(retryPolicy);

                    RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
                    queue.add(stringRequest);
                }
            }
        });

        return root;
    }
}
