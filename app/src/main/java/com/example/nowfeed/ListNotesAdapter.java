package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyun on 11/19/16.
 */
public class ListNotesAdapter extends RecyclerView.Adapter<ListNotesViewHolder> implements View.OnClickListener{


    List<String> listNotes = new ArrayList<String>(NotesCardViewHolder.getSavedHash());

    @Override
    public ListNotesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.listnotes_holder,parent,false) ;
        return new ListNotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListNotesViewHolder holder, int position) {
        holder.onBind(listNotes.get(position));
    }

    @Override
    public int getItemCount() {
        return listNotes.size();
    }

    @Override
    public void onClick(View view) {

    }
}
