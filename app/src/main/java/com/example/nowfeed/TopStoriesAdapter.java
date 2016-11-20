package com.example.nowfeed;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.nowfeed.model.TopStory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusili on 11/19/16.
 */

public class TopStoriesAdapter extends RecyclerView.Adapter {

    TopStory tsPOJO;
    private List<TopStory.results> items = new ArrayList<>();


    public TopStoriesAdapter(Object tsInput) {
        this.tsPOJO = (TopStory) tsInput;
        for (int i = 0; i < tsPOJO.getResults().size(); i++) {
            items.add(tsPOJO.getResults().get(i));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        viewHolder = new TopStoriesViewHolder(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        TopStoriesViewHolder topStoriesCard = (TopStoriesViewHolder) holder;
        topStoriesCard.onBind((TopStory.results) items.get(position));

        ((TopStoriesViewHolder) holder).ivThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = ((TopStory.results) items.get(position)).getUrl().toString();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tsPOJO.getResults().size() - 1;
    }
}
