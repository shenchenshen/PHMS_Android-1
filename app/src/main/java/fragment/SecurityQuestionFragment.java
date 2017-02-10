package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.cse6324.phms.LoginActivity;
import com.cse6324.phms.MainActivity;
import com.cse6324.phms.R;
import com.rengwuxian.materialedittext.MaterialEditText;

import org.json.JSONException;
import org.json.JSONObject;

import Bean.UserBean;
import cn.finalteam.okhttpfinal.BaseHttpRequestCallback;
import http.Constant;
import http.HttpUtil;
import okhttp3.Headers;
import okhttp3.Response;
import service.MyApplication;

/**
 * Created by Jarvis on 2017/2/10.
 */

public class SecurityQuestionFragment extends Fragment implements View.OnClickListener {

    TextView cancel, submit;
    MaterialEditText etAnswer;
    Spinner spinner;
    UserBean userBean;

    private BaseHttpRequestCallback callback = new BaseHttpRequestCallback() {
        @Override
        public void onResponse(Response httpResponse, String response, Headers headers) {

            Toast.makeText(MyApplication.getContext(),headers.get("summary"),Toast.LENGTH_LONG).show();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_security_question, null);
        initViews(v);
        return v;
    }

    public void initViews(View v) {
        cancel = (TextView) v.findViewById(R.id.btn_cancel);
        submit = (TextView) v.findViewById(R.id.btn_submit);

        etAnswer = (MaterialEditText) v.findViewById(R.id.answer);

        spinner = (Spinner) v.findViewById(R.id.spinner);

        cancel.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_cancel:
                ((LoginActivity) getActivity()).changeFragment(1);
                break;
            case R.id.btn_submit:
                if (etAnswer.getText().toString().isEmpty()) {
                    Toast.makeText(MyApplication.getContext(), "answer cannot be empty!", Toast.LENGTH_LONG).show();
                } else {

                    String security_question = spinner.getSelectedItem().toString();
                    String sq_answer = etAnswer.getText().toString();
                    MyApplication.setStringPref(MyApplication.SECURITY_QUESTION, security_question);
                    MyApplication.setStringPref(MyApplication.SQ_ANSWER, sq_answer);
                    String current_user = MyApplication.getPreferences(MyApplication.CURRENT_USER);
                    userBean = new UserBean();

                    try {
                        JSONObject jsonObject = new JSONObject(current_user);
                        userBean.setUsername(jsonObject.get("username").toString());
                        userBean.setEmail(jsonObject.getString("email"));
                        userBean.setPassword(jsonObject.getString("password"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    new HttpUtil(HttpUtil.NON_TOKEN_PARAMS)
                            .add("email", userBean.getEmail())
                            .add("name", userBean.getUsername())
                            .add("password", userBean.getPassword())
                            .add("sq", security_question)
                            .add("sqanswer", sq_answer)
                            .get(Constant.URL_REGISTER, callback);

                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    getContext().startActivity(intent);
                    getActivity().finish();
                    break;
                }
        }
    }
}

