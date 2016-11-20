package com.example.nowfeed;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;

import static com.example.nowfeed.R.id.add_notes;
import static com.example.nowfeed.R.id.notes;
import static com.example.nowfeed.R.id.save_notes;

;

/**
 * Created by Millochka on 10/31/16.
 */

public class ThirdCardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    TextView mNote;
    EditText mEdit;
    Button mAdd, mSave, mList;

    static Set<String> mAddNotes = new HashSet<String>();
    static Set<String> mSavedNotes = new HashSet<String>();

    static Set<String> lastAdded = new HashSet<String>();
    static Set<String> lastSaved = new HashSet<String>();


    public ThirdCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));

        mView = itemView;
        mNote = (TextView) mView.findViewById(notes);
        mEdit = (EditText) mView.findViewById(R.id.edit_notes);
        mAdd = (Button) mView.findViewById(R.id.add_notes);
        mAdd.setOnClickListener(this);
        mSave = (Button) mView.findViewById(R.id.save_notes);
        mSave.setOnClickListener(this);
    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.third_card, parent, false);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case add_notes:
                String addLast = mEdit.getText().toString();
                mAddNotes.add(addLast);
                Toast.makeText(view.getContext(), "added notes", Toast.LENGTH_SHORT).show();
                mEdit.setText("");
                break;
            case save_notes:
                String saveLast = mEdit.getText().toString();
                mAddNotes.add(saveLast);
                Toast.makeText(view.getContext(), "saved notes", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public static Set<String> getAddHash() {
        return mAddNotes;
    }

    public static Set<String> getSavedHash() {
        return mSavedNotes;
    }

    public static void setSavedNotes(Set<String> savedNotes) {
        lastSaved = savedNotes;
    }

    public static void setAddedNotes(Set<String> addedNotes) {
        lastAdded = addedNotes;
    }

}



