package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nowfeed.model.TopStory;
import com.squareup.picasso.Picasso;

/**
 * Created by Millochka on 10/31/16.
 */

public class TopStoriesViewHolder extends RecyclerView.ViewHolder {

    View mView;
    ImageView ivThumbnail;
    TextView tvTitle;

    public TopStoriesViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
    }


    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.topviewed_card, parent, false);
    }

    protected void onBind(TopStory.results tsPOJO) {
        ivThumbnail = (ImageView) mView.findViewById(R.id.idtopviewedthumbnail);
        tvTitle = (TextView) mView.findViewById(R.id.idtopviewedtitle);

        tvTitle.setText(tsPOJO.getTitle());
        try {
            String url = tsPOJO.getMultimedia().get(1).getUrl();
            Picasso.with(mView.getContext()).load(url).resize(400, 200).centerCrop().into(ivThumbnail);
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
