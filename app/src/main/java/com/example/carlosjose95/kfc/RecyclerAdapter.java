package com.example.carlosjose95.kfc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<viewHolder> {

    private ArrayList<SedeKFC> sedeKFC;
    private Context context;

    public RecyclerAdapter(ArrayList<SedeKFC> sedeKFCS, Context contextHolder) {
        this.sedeKFC = sedeKFCS;
        this.context = contextHolder;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.elemento_recycler, parent, false);

        return new viewHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.iImage.setImageResource(sedeKFC.get(position).getImage());
        holder.tSede.setText(sedeKFC.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return sedeKFC.size();
    }
}
