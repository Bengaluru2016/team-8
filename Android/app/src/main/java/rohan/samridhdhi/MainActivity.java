package rohan.samridhdhi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void survey(View view) {
        Intent intent = new Intent(MainActivity.this,SurveyActivity.class);
        startActivity(intent);
    }

    public void enroll(View view) {
        Intent intent = new Intent(MainActivity.this,EnrollmentActivity.class);
        startActivity(intent);
    }

    public void relocate(View view) {
        Intent intent = new Intent(MainActivity.this,RelocateActivity.class);
        startActivity(intent)
        ;
    }
    public void attendance(View view) {
        Intent intent = new Intent(MainActivity.this,AttendanceActivity.class);
        startActivity(intent)
        ;
    }
}
