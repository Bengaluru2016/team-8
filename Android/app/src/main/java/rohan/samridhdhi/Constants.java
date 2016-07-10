package rohan.samridhdhi;

/**
 * Created by Rohan on 7/9/2016.
 */
public class Constants {

    public static String name;
    public static String age;
    public static String gender;
    public static String phone;
    public static String parent_name;
    public static String parent_occupation;
    public static String parent_income;
    public static String language;
    public static String bridge;
    public static String sibling_name = "No";
    public static String sibling_age = "No";
    public static String location;
    public static String relocation;
    public static String survey = "survey";

    private static String BaseUrl = "http://52.77.224.71";

    public static String surveyUrl = BaseUrl+"/addStudentData.php";
    public static String enrollUrl = BaseUrl+"/getStudents.php";
    public static String enrollWithIdUrl = BaseUrl+"/EnrollStudent.php";
    public static String getRelocationUrl = BaseUrl+"/GetRelocation.php";
    public static String addRelocationUrl = BaseUrl+"/AddRelocation.php";
}
