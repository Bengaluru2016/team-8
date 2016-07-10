package rohan.samridhdhi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class RelocateActivity extends AppCompatActivity {

    public static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relocate);

        listView = (ListView) findViewById(R.id.list);

        new RelocateConnection(Constants.getRelocationUrl,this).execute();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                new RelocatedStudent(Constants.addRelocationUrl,EnrollmentConnection.id.get(i));
            }
        });

    }
}
