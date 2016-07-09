package rohan.samridhdhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    Animation animFadein;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        imageView=(ImageView)findViewById(R.id.logo);

        animFadein = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fadein);
        imageView.startAnimation(animFadein );
    }
}
