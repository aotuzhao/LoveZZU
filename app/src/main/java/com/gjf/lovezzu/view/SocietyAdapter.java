package com.gjf.lovezzu.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.gjf.lovezzu.R;
import com.gjf.lovezzu.entity.SchoolSociety;

import java.util.List;

/**
 * Created by zhao on 2017/3/15.
 */

public class SocietyAdapter extends RecyclerView.Adapter<SocietyAdapter.ViewHolder> {

    private List<SchoolSociety> schoolSocietyList;
    private SchoolSociety schoolSociety;
    private Context mContext;
    private Activity activity;
    private LayoutInflater inflater;

    public SocietyAdapter(List<SchoolSociety> schoolSocieties,Context mContext) {
        this.schoolSocietyList = schoolSocieties;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.society_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.societyView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件


                Toast.makeText(view.getContext(), "点击事件", Toast.LENGTH_SHORT).show();

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        schoolSociety = schoolSocietyList.get(position);

       // holder.newsImage.setImageResource(schoolSociety.getNewsImage());
        Glide.with(mContext)
                .load(schoolSociety.getHttpUrl())
                .centerCrop().thumbnail(0.1f)
                .placeholder(R.drawable.__picker_ic_photo_black_48dp)
                .error(R.drawable.__picker_ic_broken_image_black_48dp)
                .into(holder.newsImage);
        holder.newsTitle.setText(schoolSociety.getNewsTitle());
        holder.newsDate.setText(schoolSociety.getNewsDate());
        holder.newsRead.setText(schoolSociety.getNewsRead());
    }

    @Override
    public int getItemCount() {
        return schoolSocietyList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        View societyView;
        ImageView newsImage;
        TextView newsTitle;
        TextView newsDate;
        TextView newsRead;

        public ViewHolder(View itemView) {
            super(itemView);
            societyView = itemView;
            newsImage = (ImageView) itemView.findViewById(R.id.in_society_image);
            newsTitle = (TextView) itemView.findViewById(R.id.in_society_title);
            newsDate = (TextView) itemView.findViewById(R.id.in_society_date);
            newsRead = (TextView) itemView.findViewById(R.id.in_society_read);


        }
    }

}