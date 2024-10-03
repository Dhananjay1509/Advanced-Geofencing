package com.example.adavance_geofecing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    ArrayList<MyOffer> mList;
    Context context;

    public MyAdapter(ArrayList<MyOffer> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MyOffer vacancy1 = mList.get(position);
        holder.txtbname.setText("Shop Name "+vacancy1.Shopname);
        holder.txtaddress.setText("Number "+vacancy1.Mobileno);
        holder.txttype.setText("Address "+vacancy1.Address);



        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);



        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//            Toast.makeText(context.getApplicationContext(), "Add",Toast.LENGTH_LONG).show();


            Intent intent = new Intent(view.getContext(), prodetails.class);

                intent.putExtra("sname", vacancy1.getShopname());
                intent.putExtra("address",vacancy1.getAddress());
                intent.putExtra("number",vacancy1.getMobileno());
                intent.putExtra("product1",vacancy1.getProduct1());
                intent.putExtra("offer1",vacancy1.getOffer1());
                intent.putExtra("product2",vacancy1.getProduct2());
                intent.putExtra("offer2",vacancy1.getOffer2());
                intent.putExtra("url",vacancy1.getImageurl());
            view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img1;
        TextView txtbname,txtaddress,txttype;

        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            relativeLayout = itemView.findViewById(R.id.relative);

        }
    }





}
