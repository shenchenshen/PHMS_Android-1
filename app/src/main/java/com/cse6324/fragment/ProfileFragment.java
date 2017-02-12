package com.cse6324.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cse6324.phms.R;

import org.w3c.dom.Text;

/**
 * Created by Jarvis on 2017/2/11.
 */

public class ProfileFragment extends Fragment{

    TextView tvAge, tvGender, tvHeight, tvWeight, tvBp, tvBsl, tvChol;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null);

        tvAge = (TextView) v.findViewById(R.id.tv_age);
        tvGender = (TextView) v.findViewById(R.id.tv_gender);
        tvHeight = (TextView) v.findViewById(R.id.tv_height);
        tvWeight = (TextView) v.findViewById(R.id.tv_weight);
        tvBp = (TextView) v.findViewById(R.id.tv_bp);
        tvBsl = (TextView) v.findViewById(R.id.tv_bsl);
        tvChol = (TextView) v.findViewById(R.id.tv_chol);

        tvAge.setText("24");
        tvGender.setText("Male");
        tvHeight.setText("173");
        tvWeight.setText("55");
        tvBp.setText("90");
        tvBsl.setText("123.1");
        tvChol.setText("111.1");

        return v;
    }
}
