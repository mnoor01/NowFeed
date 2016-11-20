package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.nowfeed.model.BestSeller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusili on 11/19/16.
 */

public class BestSellersAdapter extends RecyclerView.Adapter {
    BestSeller bsPOJO;
    private List<BestSeller.results> items = new ArrayList<>();


    public BestSellersAdapter(Object bsInput) {
        this.bsPOJO = (BestSeller) bsInput;
        for (int i = 0; i < bsPOJO.getResults().size(); i++) {
            items.add(bsPOJO.getResults().get(i));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        viewHolder = new BestSellersViewHolder(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BestSellersViewHolder bestSellersCard = (BestSellersViewHolder) holder;
        bestSellersCard.onBind((BestSeller.results) items.get(position));
    }

    @Override
    public int getItemCount() {
        return bsPOJO.getResults().size() - 1;
    }
}
