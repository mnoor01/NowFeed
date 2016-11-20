package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nowfeed.model.TopStory;

/**
 * Created by rusili on 11/19/16.
 */

public class TopStoriesRecyclerView extends RecyclerView.ViewHolder {

    private static View v;
    RecyclerView recyclerView;
    TopStory ts;

    public TopStoriesRecyclerView(ViewGroup parent) {
        super(inflateView(parent));
        v = itemView;
    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.top_stories_card_card, parent, false);
    }

    public void onBind(TopStory tsInput) {
        this.ts = tsInput;
    }
}
