package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nowfeed.model.BestSeller;

/**
 * Created by Millochka on 10/31/16.
 */

public class BestSellersViewHolder extends RecyclerView.ViewHolder {

    View mView;
    ImageView ivThumbnail;
    TextView tvTitle, tvAuthor, tvDescription;

    public BestSellersViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
    }


    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.best_seller_card, parent, false);
    }

    protected void onBind(BestSeller bsPOJO) {
        tvTitle = (TextView) mView.findViewById(R.id.idTitle);
        tvAuthor = (TextView) mView.findViewById(R.id.idAuthor);
        tvDescription = (TextView) mView.findViewById(R.id.idDescription);

        tvTitle.setText(bsPOJO.getResults().get(1).getTitle());
        tvAuthor.setText("Author: "+bsPOJO.getResults().get(1).getAuthor());
        tvDescription.setText(bsPOJO.getResults().get(1).getDescription());
    }
}
