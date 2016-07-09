package rohan.samridhdhi;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;

/**
 * Created by Rohan on 7/9/2016.
 */
public class CommonFunctions {
    public static EditText name,age,phone,parent_name,parent_occupation,parent_income,location,language,sibling_name,sibling_age;
    public static RadioGroup gender,relocate,bridge,sibling;
    public static ImageView imageView;


    public static void first_init(View view) {
        name = (EditText) view.findViewById(R.id.name);
        age = (EditText) view.findViewById(R.id.age);
        phone = (EditText) view.findViewById(R.id.phone);
        gender = (RadioGroup) view.findViewById(R.id.gender);
    }

    public static void second_init(View view) {
        parent_name = (EditText) view.findViewById(R.id.Parent_name);
        parent_occupation = (EditText) view.findViewById(R.id.Parent_occupation);
        parent_income = (EditText) view.findViewById(R.id.Parent_income);
        location = (EditText) view.findViewById(R.id.location);
        relocate= (RadioGroup) view.findViewById(R.id.relocate);
    }

    public static void third_init(View view) {
        language = (EditText) view.findViewById(R.id.language);
        sibling_name = (EditText) view.findViewById(R.id.sibling_name);
        sibling_age= (EditText) view.findViewById(R.id.sibling_age);
        sibling_name.setVisibility(View.INVISIBLE);
        sibling_age.setVisibility(View.INVISIBLE);
        bridge = (RadioGroup) view.findViewById(R.id.bridge);
        sibling = (RadioGroup) view.findViewById(R.id.sibling);
    }


    public static void fourth_init(View view) {
        imageView = (ImageView) view.findViewById(R.id.imageView);
    }
}
