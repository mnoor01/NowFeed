package com.example.nowfeed;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nowfeed.model.Instagram;
import com.squareup.picasso.Picasso;

import java.util.Random;

/**
 * Created by Millochka on 10/31/16.
 */

public class InstagramCardViewHolder extends RecyclerView.ViewHolder {

    View mView;
    ImageView ivMedia;
    private FragmentManager supportFragmentManager;
    static InstagramFragment instafrag = new InstagramFragment();
    String sUrl;
    ImageView mLogo;
    ImageView mTitle;

    public InstagramCardViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mView = itemView;
    }

    public static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.first_card, parent, false);
    }

    protected void onBind(Instagram instagram) {
        Random rand = new Random();
        int value = rand.nextInt(instagram.getData().size() - 1);

        ivMedia = (ImageView) mView.findViewById(R.id.idCardImageView);
       mLogo = (ImageView) mView.findViewById(R.id.logo);
        mTitle = (ImageView) mView.findViewById(R.id.inst_title);

        sUrl = instagram.getData().get(value).getImages().getlow_resolution().getUrl().toString();
        instafrag.setName(sUrl);
        Log.d("sUrl", sUrl);
        Picasso.with(mView.getContext()).load(sUrl).resize(400, 200).centerCrop().into(ivMedia);
        mLogo.setImageResource(R.drawable.instagram);
        mTitle.setImageResource(R.drawable.instagram_logo);
    }

}
