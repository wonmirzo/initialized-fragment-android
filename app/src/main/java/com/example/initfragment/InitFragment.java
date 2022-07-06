package com.example.initfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class InitFragment extends Fragment {
    static String KEY = "KEY";
    static InitFragment initFragment;

    public static InitFragment newInstance(String message) {
        if (initFragment == null)
            initFragment = new InitFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY, message);

        initFragment.setArguments(bundle);
        return initFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_initfragment, container, false);
        TextView tv_message = view.findViewById(R.id.tv_message);
        tv_message.setText(getArguments().getString(KEY));

        return view;
    }
}
