package com.example.aquamizer.ui.tips;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.aquamizer.R;
import com.example.aquamizer.components.MultiSpinner;
import com.example.aquamizer.models.CATEGORY;
import com.example.aquamizer.models.Tip;

import java.util.ArrayList;
import java.util.List;

public class TipsFragment extends Fragment {

    private TipsViewModel mViewModel;
    private ListView tipsListView;

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

        //TODO refactor
        List<String> items = new ArrayList<>();
        items.add(getString(R.string.select_kitchen));
        items.add(getString(R.string.select_bathroom));
        items.add(getString(R.string.select_garden));
        items.add(getString(R.string.select_laundry));

        MultiSpinner.MultiSpinnerListener listener = new MultiSpinner.MultiSpinnerListener() {
            @Override
            public void onItemsSelected(boolean[] selected) {

                List<CATEGORY> categories = new ArrayList<>();

                if (selected[0])
                    categories.add(CATEGORY.KITCHEN);
                if (selected[1])
                    categories.add(CATEGORY.BATHROOM);
                if (selected[2])
                    categories.add(CATEGORY.GARDEN);
                if (selected[3])
                    categories.add(CATEGORY.LAUNDRY);

                mViewModel.getData(categories).observe(getViewLifecycleOwner(), new Observer<List<Tip>>() {
                    @Override
                    public void onChanged(List<Tip> tips) {
                        //TODO create custom adapter to show both category and text
                        List<String> tipsString = new ArrayList<>();

                        for (Tip t: tips) {
                            tipsString.add(t.getText());
                        }

                        ArrayAdapter<String> arrayAdapter =
                                new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, tipsString);

                        tipsListView.setAdapter(arrayAdapter);

                    }
                });
            }
        };

        MultiSpinner multiSpinner = (MultiSpinner) getView().findViewById(R.id.multi_spinner);
        multiSpinner.setItems(items, getString(R.string.select_any), listener);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(TipsViewModel.class);

        tipsListView = (ListView) getView().findViewById(R.id.tips_list);


    }

}