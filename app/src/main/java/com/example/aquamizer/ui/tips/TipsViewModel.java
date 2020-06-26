package com.example.aquamizer.ui.tips;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.aquamizer.models.CATEGORY;
import com.example.aquamizer.models.Tip;

import java.util.ArrayList;
import java.util.List;


public class TipsViewModel extends ViewModel {

    private MutableLiveData<List<Tip>> data;
    private List<Tip> tips;
    private List<Tip> filtered;

    public MutableLiveData<List<Tip>> getData(List<CATEGORY> categories) {

        if (data == null) {
            data = new MutableLiveData<List<Tip>>();
        }

        loadTips(categories);
        return data;
    }

    private void loadTips(List<CATEGORY> categories) {

        this.tips = new ArrayList<Tip>();

        tips.add(new Tip("cozinha 1", CATEGORY.KITCHEN));
        tips.add(new Tip("cozinha 2", CATEGORY.KITCHEN));
        tips.add(new Tip("banheiro 1", CATEGORY.BATHROOM));
        tips.add(new Tip("banheiro 2", CATEGORY.BATHROOM));
        tips.add(new Tip("lavanderia 1", CATEGORY.LAUNDRY));

        filtered = new ArrayList<Tip>();

        for (Tip t: tips) {

            for (CATEGORY c : categories) {
                if (t.getCategory() == c) {
                    filtered.add(t);
                    break;
                }
            }

        }

        this.data.setValue(filtered);
    }

}