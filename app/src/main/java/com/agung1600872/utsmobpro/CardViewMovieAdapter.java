package com.agung1600872.utsmobpro;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewMovieAdapter extends RecyclerView.Adapter<CardViewMovieAdapter.CardViewViewHolder>{
    private ArrayList<Result> listMovie;
    private Context context;
    CardViewMovieAdapter(Context context) {
        this.context = context;
    }
    private ArrayList<Result> getListMovie() {
        return listMovie;
    }
    void setListMovie(ArrayList<Result> listMovie) {
        this.listMovie = listMovie;
    }
    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int
            viewType) {
        View view =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_movie, parent, false);
        return new CardViewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final CardViewViewHolder holder, int position)
    {
        Movie p = getListMovie().get(position);
        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);
        holder.tvName.setText(p.getName());

        holder.btnFavorite.setOnClickListener(new
                CustomOnItemClickListener(position, new
                CustomOnItemClickListener.OnItemClickCallback() {
                    @Override
                    public void onItemClicked(View view, int position) {
                        context = view.getContext();
                        final Intent moveIntent;
                        switch (holder.getAdapterPosition()){
                            case 0:
                                moveIntent = new Intent(context,detail.class);
                                break;
                            case 1:
                                moveIntent = new Intent(context,DetailActivity2.class);
                                break;
                            case 2:
                                moveIntent = new Intent(context,DetailActivity2.class);
                                break;
                                default:
                                    moveIntent = new Intent(context,DetailActivity2.class);
                                    break;
                        }
                        context.startActivity(moveIntent);
                    }
                }));
    }
    @Override
    public int getItemCount() {
        return getListMovie().size();
    }
    class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto =
                    (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks =
                    (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite =
                    (Button)itemView.findViewById(R.id.btn_set_detail);

        }
    }
}