package com.example.myfirstapp;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class Page1 extends Activity {

    EditText emailText;
    TextView responseView;
    TextView responseView1;
    TextView response2;
    TextView responseBody2;
    TextView response3;
    TextView responseBody3;
    TextView response4;
    TextView responseBody4;
    TextView response5;
    TextView responseBody5;
    TextView search1;
    TextView searchBody1;
    TextView search2;
    TextView searchBody2;
    TextView search3;
    TextView searchBody3;
    TextView search4;
    TextView searchBody4;
    TextView search5;
    TextView searchBody5;
    ProgressBar progressBar;
    static final String API_KEY = "a6ebc0bd05a24f6f9d98cddc532f1c8e";
    static final String API_URL = "https://newsapi.org/v2/top-headlines?country=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        responseView = (TextView) findViewById(R.id.responseView);
        responseView1 = (TextView) findViewById(R.id.responseView1);
        response2 = (TextView) findViewById(R.id.response2);
        responseBody2 = (TextView) findViewById(R.id.responseBody2);
        response3 = (TextView) findViewById(R.id.response3);
        responseBody3 = (TextView) findViewById(R.id.responseBody3);
        response4 = (TextView) findViewById(R.id.response4);
        responseBody4 = (TextView) findViewById(R.id.responseBody4);
        response5 = (TextView) findViewById(R.id.response5);
        responseBody5 = (TextView) findViewById(R.id.responseBody5);
        emailText = (EditText) findViewById(R.id.emailText);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        search1 = (TextView) findViewById(R.id.search1);
        searchBody1 = (TextView) findViewById(R.id.searchBody1);
        search2 = (TextView) findViewById(R.id.search2);
        searchBody2 = (TextView) findViewById(R.id.searchBody2);
        search3 = (TextView) findViewById(R.id.search3);
        searchBody3 = (TextView) findViewById(R.id.searchBody3);
        search4 = (TextView) findViewById(R.id.search4);
        searchBody4 = (TextView) findViewById(R.id.searchBody4);
        search5 = (TextView) findViewById(R.id.search5);
        searchBody5 = (TextView) findViewById(R.id.searchBody5);



        Button queryButton = (Button) findViewById(R.id.queryButton);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new RetrieveFeedTask().execute();
            }
        });
        new preNews().execute();
    }


    class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            responseView.setText("");
        }

        protected String doInBackground(Void... urls) {
            String email = emailText.getText().toString();
            // Do some validation here

            try {
                URL url = new URL(API_URL + email + "&apiKey=" + API_KEY);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
//            responseView.setText(response);
                        try {
                JSONObject object =  new JSONObject(response);

                String articleTitle = object.getJSONArray("articles").getJSONObject(0).getString("title");

                String body = object.getJSONArray("articles").getJSONObject(0).getString("description");

                String articleTitle2 = object.getJSONArray("articles").getJSONObject(1).getString("title");

                String body2 = object.getJSONArray("articles").getJSONObject(1).getString("description");

                            String articleTitle3 = object.getJSONArray("articles").getJSONObject(2).getString("title");

                            String body3 = object.getJSONArray("articles").getJSONObject(2).getString("description");

                            String articleTitle4 = object.getJSONArray("articles").getJSONObject(3).getString("title");

                            String body4 = object.getJSONArray("articles").getJSONObject(3).getString("description");

                            String articleTitle5 = object.getJSONArray("articles").getJSONObject(4).getString("title");

                            String body5 = object.getJSONArray("articles").getJSONObject(4).getString("description");

                            //String articleDesc = object.getString("status");
                responseView.setText(articleTitle);
                responseView1.setText(body);
                response2.setText(articleTitle2);
                responseBody2.setText(body2);
                            response3.setText(articleTitle3);
                            responseBody3.setText(body3);
                            response4.setText(articleTitle4);
                            responseBody4.setText(body4);
                            response5.setText(articleTitle5);
                            responseBody5.setText(body5);

                        } catch (JSONException e) {
                e.printStackTrace();
            }




        }
    }

    class preNews extends AsyncTask<Void, Void, String> {
        private Exception exception;

        protected void onPreExecute() {
            progressBar.setVisibility(View.VISIBLE);
            search1.setText("");
        }

        protected String doInBackground(Void... urls) {


            try {
                URL url = new URL(API_URL + "us" + "&apiKey=" + API_KEY);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    StringBuilder stringBuilder = new StringBuilder();
                    String line;
                    while ((line = bufferedReader.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    bufferedReader.close();
                    return stringBuilder.toString();
                }
                finally{
                    urlConnection.disconnect();
                }
            }
            catch(Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(String response) {
            if(response == null) {
                response = "THERE WAS AN ERROR";
            }
            progressBar.setVisibility(View.GONE);
            Log.i("INFO", response);
//            responseView.setText(response);
            try {
                JSONObject object =  new JSONObject(response);

                String articleTitle = object.getJSONArray("articles").getJSONObject(0).getString("title");

                String body = object.getJSONArray("articles").getJSONObject(0).getString("description");

                String articleTitle2 = object.getJSONArray("articles").getJSONObject(1).getString("title");

                String body2 = object.getJSONArray("articles").getJSONObject(1).getString("description");

                String articleTitle3 = object.getJSONArray("articles").getJSONObject(2).getString("title");

                String body3 = object.getJSONArray("articles").getJSONObject(2).getString("description");

                String articleTitle4 = object.getJSONArray("articles").getJSONObject(3).getString("title");

                String body4 = object.getJSONArray("articles").getJSONObject(3).getString("description");

                String articleTitle5 = object.getJSONArray("articles").getJSONObject(4).getString("title");

                String body5 = object.getJSONArray("articles").getJSONObject(4).getString("description");

                //String articleDesc = object.getString("status");
                search1.setText(articleTitle);
                searchBody1.setText(body);
                search2.setText(articleTitle2);
                searchBody2.setText(body2);
                search3.setText(articleTitle3);
                searchBody3.setText(body3);
                search4.setText(articleTitle4);
                searchBody4.setText(body4);
                search5.setText(articleTitle5);
                searchBody5.setText(body5);

            } catch (JSONException e) {
                e.printStackTrace();
            }




        }

    }
}
