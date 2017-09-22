package com.azoft.carousellayoutmanager.sample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author ThomasWang
 * @since 2017/9/21 22:08
 */

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder> {
    private final List<Integer> walls;
    private final Context context;

    public DemoAdapter(Context context, List<Integer> walls) {
        this.walls = walls;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MoviePosterView postView = new MoviePosterView(context);
        postView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new ViewHolder(postView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.postView.getImage().setImageResource(walls.get(position));
    }

    @Override
    public int getItemCount() {
        return walls.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        MoviePosterView postView;

        public ViewHolder(View itemView) {
            super(itemView);
            postView = (MoviePosterView) itemView;
        }
    }
}
