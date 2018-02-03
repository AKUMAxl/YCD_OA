package com.xl.module_person;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xl.module_home.R;
import com.xl.module_library.Base.BaseFragment;


/**
 * Created by ADMIN on 2017/11/11.
 */

public class PersonFragment extends BaseFragment {

    public PersonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false);
    }


}
