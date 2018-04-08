package com.example.tarek.tourguidapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FragmentItemActivity extends Fragment {

    @BindView(R.id.category_item_image)
    ImageView locationImage;
    @BindView(R.id.location_name)
    TextView locationName;
    @BindView(R.id.id_text)
    TextView locationAddress;
    @BindView(R.id.category_item_text_description)
    TextView locationDescription;

    private int placeImage;
    private String placeName;
    private String placeAddress;
    private String placeDescription;


    public FragmentItemActivity() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.category_item, container, false);
        ButterKnife.bind(this, rootView);

        locationImage.setImageResource(placeImage);
        locationName.setText(placeName);
        locationAddress.setText(placeAddress);
        locationDescription.setText(placeDescription);

        return rootView;
    }

    public void setPlaceImage(int image) {
        this.placeImage = image;
    }

    public void setPlaceName(String name) {
        this.placeName = name;
    }

    public void setPlaceAddress(String address) {
        this.placeAddress = address;
    }

    public void setPlaceDescription(String description) {
        this.placeDescription = description;
    }
}
