package com.example.a360rfandroidapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class InternshipFragment extends Fragment {

    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_internship, container, false);

        webView = root.findViewById(R.id.internshipFormWebView);

        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScELAm_nne9AlBtHqgF0q60qr07Re0vHjFS8lT-05W1Ga7p8Q/viewform");

        return root;
    }
}