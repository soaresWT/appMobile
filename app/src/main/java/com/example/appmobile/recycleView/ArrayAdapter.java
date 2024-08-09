package com.example.appmobile.recycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmobile.R;

import java.util.ArrayList;

public class ArrayAdapter extends RecyclerView.Adapter<ArrayAdapter.ViewHolder> {
    private int listItemLayout;
    private ArrayList<Item> itemList;

    public ArrayAdapter(int layoutId, ArrayList<Item> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }
    @Override
    public int getItemCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        Item item = itemList.get(listPosition);

        holder.titulo.setText(item.getTitulo());
        holder.descricao.setText(item.getDescricao());
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView titulo;
        public TextView descricao;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titulo = itemView.findViewById(R.id.textTitulo);
            descricao = itemView.findViewById(R.id.textDescricao);
        }

        @Override
        public void onClick(View view) {
        }
    }
}
