package rohan.tracking;

import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

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
public class MyService extends Service implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    static LocationRequest locationRequest;
    static GoogleApiClient googleApiClient;
    public static Location loc;
    public static String Response = "";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // connect to play services to get location
        connectToGoogleApi();

        return START_STICKY;
    }



    public void connectToGoogleApi() {

        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this) == ConnectionResult.SUCCESS) {

            googleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(LocationServices.API)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();

            if (!googleApiClient.isConnected() || !googleApiClient.isConnecting()) {
                googleApiClient.connect();
                Log.d("TAG", "connect");
            }
        } else {
            Log.e("TAG", "unable to connect to google play services.");
        }

    }


    @Override
    public void onConnected(Bundle bundle) {
        Log.d("TAG", "connected");
        locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000); // milliseconds
        locationRequest.setFastestInterval(1000); // the fastest rate in milliseconds at which your app can handle location updates
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


        LocationServices.FusedLocationApi.requestLocationUpdates(
                googleApiClient, locationRequest, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        loc = location;
                    }
                });
    }


    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }
    public static void sendLoc(final Location location) {

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... params) {

                URL url;
                try {
                        url = new URL("http://52.77.224.71/relocate.php");

                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setRequestMethod("POST");

                    Uri.Builder builder = new Uri.Builder()
                            .appendQueryParameter("sid","1")
                            .appendQueryParameter("location", loc.getLatitude() + ","+loc.getLongitude());



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
        }.execute();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
