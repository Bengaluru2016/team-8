package rohan.samridhdhi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {

    ViewPager mPager;
    public static ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    boolean  enroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        Intent intent = getIntent();
        enroll  = intent.getBooleanExtra("enroll",false);

        init();
    }

    private void init() {
        // initialize the fab
          FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        // initialize the pager
        mPager = (ViewPager) findViewById(R.id.pager);

        // adding fragments
        fragmentArrayList.add(new FragmentFirst());
        fragmentArrayList.add(new FragmentSecond());
        fragmentArrayList.add(new FragmentThird());
        fragmentArrayList.add(new FragmentFourth());

        // setting the pager adapter
        mPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

        // fab onClick to move

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = mPager.getCurrentItem();
                // last item
                if (position == (fragmentArrayList.size()-1)){
//                    Toast.makeText(SurveyActivity.this, "Send the data to db", Toast.LENGTH_SHORT).show();
                    CommonFunctions.getData(enroll);
                }
                else {
                    mPager.setCurrentItem((mPager.getCurrentItem()+1));
                }
            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            FragmentFourth ff = (FragmentFourth) fragmentArrayList.get(3);
            ImageView i = (ImageView) ff.view.findViewById(R.id.imageView);
            i.setImageBitmap(imageBitmap);
        }

    }
}