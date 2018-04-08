package com.example.tarek.tourguidapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryItemAdapter extends ArrayAdapter<CategoryItem> {

    private Context mContext;

    public CategoryItemAdapter(@NonNull Context context, ArrayList<CategoryItem> categories) {
        super(context, 0, categories);
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View rootView = convertView;
        ViewHolderItem viewHolderItem;
        if (rootView == null) {
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            rootView = inflater.inflate(R.layout.image_text_h_layout, parent, false);

            //link views by viewHolder
            viewHolderItem = new ViewHolderItem();
            viewHolderItem.categoryName = rootView.findViewById(R.id.id_text);
            viewHolderItem.categoryImageId = rootView.findViewById(R.id.id_image);

            rootView.setTag(viewHolderItem);

        } else {
            viewHolderItem = (ViewHolderItem) rootView.getTag();
        }
        CategoryItem category = getItem(position);

        viewHolderItem.categoryName.setText(category.getCategoryName());
        viewHolderItem.categoryImageId.setImageResource(category.getCategoryImageResourceID());

        return rootView;
    }


    public static class ViewHolderItem {
        TextView categoryName;
        ImageView categoryImageId;
    }
}
