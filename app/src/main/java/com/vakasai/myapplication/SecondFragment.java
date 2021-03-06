package com.vakasai.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


import com.vakasai.myapplication.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    int bottom;

    public void addToBottomView(TextView tv, ConstraintLayout lay, String s) {
        tv.setText(s);
        tv.setId(View.generateViewId());
        tv.setTextSize(20);
        ConstraintSet set = new ConstraintSet();
        lay.addView(tv, 0);
        set.clone(lay);
        set.connect(tv.getId(), ConstraintSet.TOP, bottom, ConstraintSet.BOTTOM, 10);
        set.connect(tv.getId(), ConstraintSet.LEFT, lay.getId(), ConstraintSet.LEFT, 0);
        set.connect(tv.getId(), ConstraintSet.RIGHT, lay.getId(), ConstraintSet.RIGHT, 0);
        set.applyTo(lay);
        bottom = tv.getId();
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /* defaults for testing */
        String type = "Workout";
        int[] st = {5, 30};
        int[] end = {6, 30};
        String date = "4/30/22";
        String proxyNumber = "1-716-325-9812";
        TextView tv3 = getView().findViewById(R.id.proxyNum);
        tv3.setText(tv3.getText() + " " +  proxyNumber);
        ConstraintLayout lay = getView().findViewById(R.id.frag2);
        bottom = R.id.proxyNum;
        addToBottomView(new TextView(getActivity()), lay, type);
        addToBottomView(new TextView(getActivity()), lay,
                st[0] + ":" + st[1] + " - " + end[0] + ":" + end[1]);
        addToBottomView(new TextView(getActivity()), lay, date);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}