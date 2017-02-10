package Bean;

import android.content.Context;
import android.widget.Toast;

import util.FormatUtil;

/**
 * Created by hopelty on 2017/2/10.
 */

public class UserBean {
    private String email;
    private String username;
    private String password;
    private String password2;

    public UserBean(){}

    public UserBean(String email,String username,String password,String password2){
        this.email = email;
        this.username = username;
        this.password = password;
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public boolean isValid(UserBean userBean, Context context){

        boolean bool = true;
        if(userBean.getEmail().isEmpty()) {
            bool = false;
            Toast.makeText(context, "email cannot be empty!", Toast.LENGTH_LONG).show();
        }

        if(!FormatUtil.checkEmail(userBean.getEmail())) {
            bool = false;
            Toast.makeText(context, "please enter valid email!", Toast.LENGTH_LONG).show();
        }

        if(userBean.getUsername().isEmpty()) {
            bool = false;
            Toast.makeText(context, "username cannot be empty!", Toast.LENGTH_LONG).show();
        }

        if(userBean.getPassword().isEmpty()||userBean.getPassword().length()<=8) {
            bool = false;
            Toast.makeText(context, "password cannot be empty!", Toast.LENGTH_LONG).show();
        }

        if(!userBean.getPassword().equals(userBean.getPassword2())) {
            bool = false;
            Toast.makeText(context, "enter the password twice inconsistent!", Toast.LENGTH_LONG).show();
        }

        return bool;
    }
}
