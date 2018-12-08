package com.example.carlosjose95.kfc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView iImage;
    TextView tSede;
    Button bNavegar;
    Context contextHolder;

    public viewHolder(View itemView, Context context) {
        super(itemView);

        iImage = itemView.findViewById(R.id.iImage);
        tSede = itemView.findViewById(R.id.tSede);
        bNavegar = itemView.findViewById(R.id.bNavegar);

        contextHolder = context;

        bNavegar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int position = getAdapterPosition();

        Intent intent = new Intent(contextHolder, ViewMapActivity.class);
        intent.putExtra("numero", position);
        intent.putExtra("bandera", false);

    }
}
