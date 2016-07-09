package rohan.samridhdhi;

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
 * Created by Rohan on 7/9/2016.
 */
public class SurveyConnection extends AsyncTask<Void,Void,Void> {

    String urlString;
    String Response = "";

    SurveyConnection(String url)
    {
        this.urlString = url;
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
                    .appendQueryParameter("name", Constants.name)
                    .appendQueryParameter("age", Constants.age)
                    .appendQueryParameter("gender", Constants.gender)
                    .appendQueryParameter("phone", Constants.phone)
                    .appendQueryParameter("sibling_age", Constants.sibling_age)
                    .appendQueryParameter("sibling_name", Constants.sibling_name)
                    .appendQueryParameter("parents_name", Constants.parent_name)
                    .appendQueryParameter("parents_income", Constants.parent_income)
                    .appendQueryParameter("parents_occupation", Constants.parent_occupation)
                    .appendQueryParameter("language", Constants.language)
                    .appendQueryParameter("bridge", Constants.bridge)
                    .appendQueryParameter("location", Constants.location)
                    .appendQueryParameter("relocated", Constants.relocation);


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
