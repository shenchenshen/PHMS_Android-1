package fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.cse6324.phms.LoginActivity;
import com.cse6324.phms.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import Bean.UserBean;
import service.MyApplication;

/**
 * Created by Jarvis on 2017/2/10.
 */

public class RegisterFragment extends Fragment implements View.OnClickListener{

    TextView cancel,submit;
    MaterialEditText etEmail,etPassword,confPassword,etUsername;
    UserBean userBean;
    String current_user;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_register, null);
        initViews(v);
        return v;
    }

    public void initViews(View v){
        cancel = (TextView) v.findViewById(R.id.btn_cancel);
        submit = (TextView) v.findViewById(R.id.btn_submit);

        etEmail = (MaterialEditText) v.findViewById(R.id.email) ;
        etUsername = (MaterialEditText) v.findViewById(R.id.username);
        etPassword = (MaterialEditText) v.findViewById(R.id.password);
        confPassword = (MaterialEditText) v.findViewById(R.id.password2);
        etPassword.setTypeface(Typeface.DEFAULT);
        etPassword.setTransformationMethod(new PasswordTransformationMethod());
        confPassword.setTypeface(Typeface.DEFAULT);
        confPassword.setTransformationMethod(new PasswordTransformationMethod());

        cancel.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_cancel:
                ((LoginActivity)getActivity()).changeFragment(0);
                break;
            case R.id.btn_submit:
                userBean = new UserBean(etEmail.getText().toString(),etUsername.getText().toString(),
                            etPassword.getText().toString(),confPassword.getText().toString());

                if(userBean.isValid(userBean,MyApplication.getContext())) {

                    current_user = JSON.toJSONString(userBean).toString();
                    MyApplication.setStringPref(MyApplication.CURRENT_USER, current_user);
                    ((LoginActivity) getActivity()).changeFragment(2);
                }
                break;
        }
    }
}
