package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cse6324.phms.LoginActivity;
import com.cse6324.phms.R;

/**
 * Created by Jarvis on 2017/2/10.
 */

public class RegisterFragment extends Fragment implements View.OnClickListener{

    TextView cancel,submit;

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
                ((LoginActivity)getActivity()).changeFragment(2);
                break;
        }
    }
}
