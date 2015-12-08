package ovol.Values;

/**
 * Created by ovo on 07.12.2015.
 */
public class ValuesForTest {
    private static String zikUrl = "http://www.zik.ua";
    private static String tabZikVlada = "body > div > div:nth-child(6) > div > div > div > div.level2 > ul > li:nth-child(4) > a";
    private static String courseraUrl = "http://www.coursera.org";

    private static String tabCourseraSignUp = "c-navbar-list bt3-nav bt3-navbar-nav bt3-navbar-right";
    private static String buttonSignUp = "bt3-btn bt3-btn-primary active";



    public String getZikUrl() {
        return zikUrl;
    }

    public String getCourseraUrl() {
        return courseraUrl;
    }

    public String getTabVlada() {
        return tabZikVlada;
    }
    public String getTabCourseraSignUp(){
        return tabCourseraSignUp;
    }
    public String getButtonSignUp(){
        return buttonSignUp;
    }


    ValuesForTest gotValues = new ValuesForTest();
    String forZikUrl = gotValues.getZikUrl();
    String forTabVlada = gotValues.getTabVlada();
    String forCourseraUrl = gotValues.getCourseraUrl();
    String forCourseraSignUp = gotValues.getTabCourseraSignUp();
    String forSignUpButtton = gotValues.getButtonSignUp();



}
