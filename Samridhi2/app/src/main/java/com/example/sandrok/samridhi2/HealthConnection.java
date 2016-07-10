package com.example.sandrok.samridhi2;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Rohan on 7/10/2016.
 */
public class HealthConnection extends AsyncTask<Void, Void, Void> {

    String urlString;
    String Response = "";
    String height;
    String weight;
    String dental;
    String overall;
    String name;

    HealthConnection(String url, String name,String height, String weight, String dental, String overall) {
        this.urlString = url;
        this.height=height;
        this.weight=weight;
        this.dental=dental;
        this.overall=overall;
        this.name=name;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        URL url;
        try {
            url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("name", name)
                    .appendQueryParameter("height", height)
                    .appendQueryParameter("weight", weight)
                    .appendQueryParameter("overall", overall)
                    .appendQueryParameter("dental", dental);


            String query = builder.build().getEncodedQuery();

            Log.d("test", query);

            OutputStream os = httpURLConnection.getOutputStream();

            BufferedWriter mBufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            mBufferedWriter.write(query);
            mBufferedWriter.flush();
            mBufferedWriter.close();
            os.close();

            httpURLConnection.connect();
            BufferedReader mBufferedInputStream = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inline;
            while ((inline = mBufferedInputStream.readLine()) != null) {
                Response += inline;
            }
            mBufferedInputStream.close();
            Log.d("response", Response);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Response = "";

        return null;
    }
}

