package com.example.application3a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.VideoView;

import com.google.gson.Gson;

public class DisplaySchoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_school);

        Gson gson = new Gson();
        String strObj = getIntent().getStringExtra("obj");
        Players obj = gson.fromJson(strObj, Players.class);

        TextView schoolName = findViewById(R.id.textNameSchool);
        schoolName.setBackgroundColor(0xff0000ff);

        schoolName.setText(obj.getUser());
        schoolName.setTextColor(0xff000000);


        //WebView webView = findViewById(R.id.webView);
        //webView.setWebViewClient(new WebViewClient());
        //webView.loadUrl("https://fr.wikipedia.org/w/index.php?search="+obj.getUser());


        TextView pays = findViewById(R.id.textPays);
        pays.setText("Location : " +obj.getCountry());

        TextView url = findViewById(R.id.textURL);
        url.setText("Siteweb : " + obj.getURLList().get(0));

        TextView domaine = findViewById(R.id.textDomaines);
        domaine.setText("Domaine : " + obj.getDomainsList().get(0));
    }




}
