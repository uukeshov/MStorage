package storage.com.mstorage.viewholders;


import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import storage.com.mstorage.R;

/**
 * Created by uukeshov on 15.08.2016.
 */
public class TovarViewHolder extends RecyclerView.ViewHolder {
    TextView tvMovieName;
    ImageView ivMoviePoster;
    CardView card_view;

    public TovarViewHolder(View v) {
        super(v);
        tvMovieName = (TextView) v.findViewById(R.id.tv_name);
        ivMoviePoster = (ImageView) v.findViewById(R.id.iv_movie_poster);
        card_view = (CardView) v.findViewById(R.id.card_view);
    }

    public TextView getTvMovieName() {
        return tvMovieName;
    }

    public void setTvMovieName(TextView tvMovieName) {
        this.tvMovieName = tvMovieName;
    }

    public ImageView getIvMoviePoster() {
        return ivMoviePoster;
    }

    public void setIvMoviePoster(ImageView ivMoviePoster) {
        this.ivMoviePoster = ivMoviePoster;
    }

    public CardView getCard_view() {
        return card_view;
    }

    public void setCard_view(CardView card_view) {
        this.card_view = card_view;
    }
}