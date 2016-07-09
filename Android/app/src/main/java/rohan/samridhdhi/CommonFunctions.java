package rohan.samridhdhi;

import android.app.Activity;
import android.content.Intent;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * Created by Rohan on 7/9/2016.
 */
public class CommonFunctions {
    public static EditText name, age, phone, parent_name, parent_occupation, parent_income, location, language, sibling_name, sibling_age, relocateLocation;
    public static RadioGroup gender, relocate, bridge, sibling;
    public static ImageView imageView;
    public static boolean _sibling = false, _relocate = false;


    public static void first_init(View view) {
        name = (EditText) view.findViewById(R.id.name);
        age = (EditText) view.findViewById(R.id.age);
        phone = (EditText) view.findViewById(R.id.phone);
        gender = (RadioGroup) view.findViewById(R.id.gender);
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup gr, int id) {
                switch (id) {
                    case R.id.male:
                        Constants.gender = "male";
                        break;
                    case R.id.female:
                        Constants.gender = "female";
                        break;
                }
            }
        });
    }

    public static void second_init(View view) {
        parent_name = (EditText) view.findViewById(R.id.Parent_name);
        parent_occupation = (EditText) view.findViewById(R.id.Parent_occupation);
        parent_income = (EditText) view.findViewById(R.id.Parent_income);
        location = (EditText) view.findViewById(R.id.location);
        relocateLocation = (EditText) view.findViewById(R.id.nativeLocation);
        relocateLocation.setVisibility(View.INVISIBLE);
        relocate = (RadioGroup) view.findViewById(R.id.relocate);
        relocate.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup gr, int id) {
                switch (id) {
                    case R.id.relocate_yes:
                        relocateLocation.setVisibility(View.VISIBLE);
                        _relocate = true;
                        break;
                    case R.id.relocate_no:
                        relocateLocation.setVisibility(View.INVISIBLE);
                        _relocate = false;
                        Constants.relocation = "no";
                        break;
                }
            }
        });
    }

    public static void third_init(View view) {
        language = (EditText) view.findViewById(R.id.language);
        sibling_name = (EditText) view.findViewById(R.id.sibling_name);
        sibling_age = (EditText) view.findViewById(R.id.sibling_age);
        sibling_name.setVisibility(View.INVISIBLE);
        sibling_age.setVisibility(View.INVISIBLE);
        bridge = (RadioGroup) view.findViewById(R.id.bridge);
        bridge.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup gr, int id) {
                switch (id) {
                    case R.id.bridge_yes:
                        Constants.bridge = "mainstream";
                        break;
                    case R.id.bridge_no:
                        Constants.bridge = "bridge";
                        break;
                }
            }
        });
        sibling = (RadioGroup) view.findViewById(R.id.sibling);
        sibling.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup gr, int id) {
                switch (id) {
                    case R.id.sibling_yes:
                        //              Constants.sibling="yes";
                        sibling_name.setVisibility(View.VISIBLE);
                        sibling_age.setVisibility(View.VISIBLE);
                        _sibling = true;
                        break;
                    case R.id.sibling_no:
                        Constants.bridge = "no";
                        sibling_name.setVisibility(View.INVISIBLE);
                        sibling_age.setVisibility(View.INVISIBLE);
                        _sibling = false;
                        break;
                }
            }
        });

    }


    public static void fourth_init(View view, Activity c) {
        imageView = (ImageView) view.findViewById(R.id.imageView);
        final Activity t = c;
        imageView.setOnClickListener(new ImageView.OnClickListener()

        {
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(t.getPackageManager()) != null) {
                    t.startActivityForResult(takePictureIntent, 1);
                }
            }
        });
    }

    public static void getData(boolean enroll) {
        // getting the data from edit texts
        Constants.name = name.getText().toString();
        Constants.age = age.getText().toString();
        Constants.phone = phone.getText().toString();
        Constants.parent_name = parent_name.getText().toString();
        Constants.parent_occupation = parent_occupation.getText().toString();
        Constants.parent_income = parent_income.getText().toString();
        Constants.location = location.getText().toString();
        Constants.language = language.getText().toString();
        if (_sibling) {
            Constants.sibling_name = sibling_name.getText().toString();
            Constants.sibling_age = sibling_age.getText().toString();
        }
        if (_relocate) {
            Constants.relocation = relocateLocation.getText().toString();
        }

        if (enroll) {
            new SurveyConnection(Constants.enrollAddUrl).execute();
        } else
            new SurveyConnection(Constants.surveyUrl).execute();
    }
}
