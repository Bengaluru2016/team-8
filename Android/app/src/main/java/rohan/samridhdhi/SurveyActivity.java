package rohan.samridhdhi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class SurveyActivity extends AppCompatActivity {

    ViewPager mPager;
    public static ArrayList<Fragment> fragmentArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        init();
    }

    private void init() {
        // initialize the pager
        mPager = (ViewPager) findViewById(R.id.pager);

        // adding fragments
        fragmentArrayList.add(new FragmentFirst());
        fragmentArrayList.add(new FragmentSecond());

        // setting the pager adapter
        mPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }
}
