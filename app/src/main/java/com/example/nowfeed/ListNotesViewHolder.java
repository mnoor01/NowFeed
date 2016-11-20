package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Hyun on 11/20/16.
 */
public class ListNotesViewHolder extends RecyclerView.ViewHolder{
    
    TextView listTextView;


    public ListNotesViewHolder(View itemView) {
        super(itemView);
        listTextView = (TextView) itemView.findViewById(R.id.listnotesholder_TV);
    }

    public void onBind(String s) {
        listTextView.setText(s);
    }
}
