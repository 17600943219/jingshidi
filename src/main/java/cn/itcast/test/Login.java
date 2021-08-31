package cn.itcast.test;

public class Login {
    //    public static  Commonshare common= new Commonshare();
    public void login(String username, String pwd) {
        Commonshare.openUrl("https://passport.yhd.com/passport/login_input.do");
        Commonshare.inputData("id", "un", username);
        Commonshare.inputData("id", "pwd", pwd);
        Commonshare.click("id", "login_button");

    }


}
