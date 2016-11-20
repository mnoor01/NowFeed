package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nowfeed.model.BestSeller;

/**
 * Created by rusili on 11/19/16.
 */

public class BestSellersRecyclerView extends RecyclerView.ViewHolder {
    private static View v;
    RecyclerView recyclerView;
    BestSeller bs;

    public BestSellersRecyclerView(ViewGroup parent) {
        super(inflateView(parent));
        v = itemView;
    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.best_seller_card_card, parent, false);
    }

    public void onBind(BestSeller bestSeller) {
        this.bs = bestSeller;
    }
}
