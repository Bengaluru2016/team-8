package rohan.samridhdhi;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Rohan on 7/9/2016.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {


    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return SurveyActivity.fragmentArrayList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Survey Stage "+(position+1);
    }

    @Override
    public int getCount() {
        return SurveyActivity.fragmentArrayList.size();
    }
}
