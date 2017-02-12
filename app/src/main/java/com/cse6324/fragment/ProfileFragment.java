package com.cse6324.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cse6324.bean.UserBean;
import com.cse6324.phms.LoginActivity;
import com.cse6324.phms.R;
import com.cse6324.phms.SettingActivity;
import com.cse6324.service.MyApplication;
import com.cse6324.util.UserUtil;

import org.w3c.dom.Text;

/**
 * Created by Jarvis on 2017/2/11.
 */

public class ProfileFragment extends Fragment implements View.OnClickListener{

    TextView tvName, tvEmail, tvAge, tvGender, tvHeight, tvWeight, tvBp, tvBsl, tvChol;

    LinearLayout llSetting;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);

        tvName = (TextView) v.findViewById(R.id.tv_name);
        tvEmail = (TextView) v.findViewById(R.id.tv_email);
        tvAge = (TextView) v.findViewById(R.id.tv_age);
        tvGender = (TextView) v.findViewById(R.id.tv_gender);
        tvHeight = (TextView) v.findViewById(R.id.tv_height);
        tvWeight = (TextView) v.findViewById(R.id.tv_weight);
        tvBp = (TextView) v.findViewById(R.id.tv_bp);
        tvBsl = (TextView) v.findViewById(R.id.tv_bsl);
        tvChol = (TextView) v.findViewById(R.id.tv_chol);

        llSetting = (LinearLayout) v.findViewById(R.id.layout_setting);
        llSetting.setOnClickListener(this);

        tvName.setText(MyApplication.getPreferences(UserUtil.UNAME));
        tvEmail.setText(MyApplication.getPreferences(UserUtil.EMAIL));
        tvAge.setText("24");
        tvGender.setText("Male");
        tvHeight.setText("173");
        tvWeight.setText("55");
        tvBp.setText("90");
        tvBsl.setText("123.1");
        tvChol.setText("111.1");

        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.layout_setting:
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                getContext().startActivity(intent);
                break;
        }
    }
}
