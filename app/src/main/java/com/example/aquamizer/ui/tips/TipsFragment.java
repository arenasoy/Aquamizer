package com.example.aquamizer.ui.tips;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aquamizer.R;
import com.example.aquamizer.components.MultiSpinner;

import java.util.ArrayList;
import java.util.List;

public class TipsFragment extends Fragment {

    private TipsViewModel mViewModel;

    public static TipsFragment newInstance() {
        return new TipsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.tips_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> items = new ArrayList<>();
        items.add(getString(R.string.select_kitchen));
        items.add(getString(R.string.select_bathroom));
        items.add(getString(R.string.select_garden));
        items.add(getString(R.string.select_laundry));

        MultiSpinner.MultiSpinnerListener listener = new MultiSpinner.MultiSpinnerListener() {
            @Override
            public void onItemsSelected(boolean[] selected) {

            }
        };

        MultiSpinner multiSpinner = (MultiSpinner) getView().findViewById(R.id.multi_spinner);
        multiSpinner.setItems(items, getString(R.string.select_any), listener);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TipsViewModel.class);


        // TODO: Use the ViewModel
    }

}