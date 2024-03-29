package rohan.samridhdhi;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
import java.util.ArrayList;

/**
 * Created by Rohan on 7/10/2016.
 */
public class GetAttendance extends AsyncTask<Void,Void,Void>{

    String urlString;
    String Response = "";
    Context context;
    String location;

    public GetAttendance(String s, Context attendanceActivity,String url) {
        location = s;
        context = attendanceActivity;
        urlString = url;
    }

    ArrayList<String> listArray = new ArrayList<>();

    @Override
    protected void onPostExecute(Void aVoid) {
        try {
            JSONArray jsonArray = new JSONArray(Response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                listArray.add(jsonObject.getString("name")+" "+jsonObject.getString("present"));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (Response.equals("[]")){
            listArray.add("Rohan 5");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, listArray);
        AttendanceActivity.listView.setAdapter(adapter);


        super.onPostExecute(aVoid);
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
                    .appendQueryParameter("location", location);


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

        return null;
    }
}
