package com.example.sandrok.samridhi2;

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
public class GetStudents extends AsyncTask<Void,Void,Void> {

    String location;
    int _bridge;
    String urlSelect[] = {"http://52.77.224.71/AttendanceMainstream.php","http://52.77.224.71/AttendanceList.php"};
    String Response = "";
    Context context;
    public static ArrayList<String> listArray = new ArrayList<>();
    public static ArrayList<String> id = new ArrayList<>();

    public GetStudents(String string, int _bridge,Context context) {
        location = string;
        this._bridge = _bridge;
        this.context = context;
    }


    @Override
    protected void onPostExecute(Void aVoid) {

        try {
            JSONArray jsonArray = new JSONArray(Response);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                listArray.add(jsonObject.getString("name"));
                id.add(jsonObject.getString("id"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context,
                android.R.layout.simple_list_item_1, listArray);
        EnterDetailsActivity.listView.setAdapter(adapter);

        super.onPostExecute(aVoid);
    }
    @Override
    protected Void doInBackground(Void... voids) {
        URL url;
        try {
            url = new URL(urlSelect[_bridge]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");


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
