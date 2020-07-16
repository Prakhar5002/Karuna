package com.Final.karuna.videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.Final.karuna.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> url;
    private  ArrayList<String> title;
    private ArrayList<String> id;
    private OnPressedListener onPressedListener1;

    public MyAdapter(ArrayList<String> url, ArrayList<String> title, ArrayList<String> id,OnPressedListener onPressedListener){
        this.url = url;
        this.id = id;
        this.title = title;
        this.onPressedListener1 = onPressedListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_view, parent,false);

        return new MyViewHolder(view, onPressedListener1);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.text.setText(title.get(position));
        try {
            Picasso.get().load(url.get(position)).into(holder.image);
            // holder.image.setImageBitmap(url.get(position));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView image;
        TextView text;
        OnPressedListener onPressedListener;
        public MyViewHolder(@NonNull View itemView, OnPressedListener onPressedListener) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            text = itemView.findViewById(R.id.text);
            itemView.setOnClickListener(this);
            this.onPressedListener = onPressedListener;
        }

        @Override
        public void onClick(View v) {
            onPressedListener.onPress(getAdapterPosition());
        }
    }
    public interface OnPressedListener{
        void onPress(int position);
    }
}

