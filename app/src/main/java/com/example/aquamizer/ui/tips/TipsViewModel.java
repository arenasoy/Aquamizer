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

        tips.add(new Tip("Feche a torneira enquanto ensaboa a louça", CATEGORY.KITCHEN));
        tips.add(new Tip("Retire o excesso de sujeira das louças antes de começar a lavar", CATEGORY.KITCHEN));
        tips.add(new Tip("Deixe as louças de molho antes de lavar", CATEGORY.KITCHEN));
        tips.add(new Tip("Lave frutas e verduras em uma bacia", CATEGORY.KITCHEN));
        tips.add(new Tip("Desligue o chuveiro enquanto se ensaboa", CATEGORY.BATHROOM));
        tips.add(new Tip("Pressione a descarga somente o tempo necessário", CATEGORY.BATHROOM));
        tips.add(new Tip("Tome banhos mais rápidos", CATEGORY.BATHROOM));
        tips.add(new Tip("Escove os dentes com a torneira fechada", CATEGORY.BATHROOM));
        tips.add(new Tip("Use regadores em vez de uma mangueira", CATEGORY.GARDEN));
        tips.add(new Tip("Varra em vez de lavar as calçadas", CATEGORY.GARDEN));
        tips.add(new Tip("Armazene a água da chuva", CATEGORY.GARDEN));
        tips.add(new Tip("Use a máquina de lavar somemnte quando tiver quantidade de roupas suficiente para enchê-la", CATEGORY.LAUNDRY));
        tips.add(new Tip("Reaproveite a água da máquina de lavar", CATEGORY.LAUNDRY));
        tips.add(new Tip("Lave roupas a mão", CATEGORY.LAUNDRY));
        tips.add(new Tip("Enxague as roupas apenas uma vez", CATEGORY.LAUNDRY));
        tips.add(new Tip("Deixe as roupas de molho antes de lavar", CATEGORY.LAUNDRY));

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