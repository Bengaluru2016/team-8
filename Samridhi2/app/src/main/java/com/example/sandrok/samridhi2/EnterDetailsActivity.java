package com.example.sandrok.samridhi2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EnterDetailsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static ListView listView;
    int _bridge = 0;
    public static ArrayList<String> presentIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate
                (savedInstanceState);
        setContentView(R.layout.activity_enter_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        _bridge = intent.getIntExtra("Bridge",0);

        listView = (ListView) findViewById(R.id.list);


        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(EnterDetailsActivity.this);
        final EditText input = new EditText(EnterDetailsActivity.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        alertDialog.setView(input);
        alertDialog.setTitle("Enter the location!");
        alertDialog.setPositiveButton("PROCEED", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                new GetStudents(input.getText().toString(),_bridge,EnterDetailsActivity.this).execute();
            }
        });
        alertDialog.setNegativeButton("CANCEL", null);
        alertDialog.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presentIds.add(GetStudents.id.get(i));
                new UpdateAttendance("http://52.77.224.71/UpdateAttendance.php",GetStudents.id.get(i)).execute();
                Toast.makeText(EnterDetailsActivity.this, GetStudents.listArray.get(i)+" was marked present", Toast.LENGTH_SHORT).show();

            }
        });



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.enter_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent intent = new Intent(EnterDetailsActivity.this,MarksActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_slideshow) {
            Intent intent = new Intent(EnterDetailsActivity.this,HealthActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_share){
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9880290275"));
            startActivity(intent);
        }
        else if (id == R.id.nav_send){
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Join your hands to give a wonderful future to the deserved ones. Invest in the future of India!! Spread the word about Samridhdhi Trust.");
            sendIntent.setType("text/plain");
            startActivity(Intent.createChooser(sendIntent, "Samridhdhi trust"));

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
