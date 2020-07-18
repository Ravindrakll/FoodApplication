package com.codegama.fooddeliveryapp.screens.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codegama.fooddeliveryapp.R;
import com.codegama.fooddeliveryapp.screens.categorymodel.Categories;
import com.codegama.fooddeliveryapp.screens.categorymodel.Category;


import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MyViewHolder> {
    private Context context;
    private List<Category> categoriesList;
    private List<ImageList> lists;

    public CategoriesAdapter(Context context, List<Category> categoriesList, List<ImageList> lists) {
        this.context = context;
        this.categoriesList = categoriesList;
        this.lists = lists;
    }

    @NonNull
    @Override
    public CategoriesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.MyViewHolder holder, int position) {
        holder.categoryName.setText(categoriesList.get(position).getCategories().getName());
        holder.categoryImage.setImageResource(lists.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView categoryName;
        private ImageView categoryImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.category_name);
            categoryImage = itemView.findViewById(R.id.category_imgs);

        }
    }
}
