package com.example.tarek.tourguidapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;
    private String currentCategory;
    private ArrayList<Location> locations;
    private int count;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm, String category) {
        super(fm);
        mContext = context;
        currentCategory = category;
        setLocations();
        count = locations.size();
    }

    @Override
    public Fragment getItem(int position) {

        Location location;
        location = locations.get(position);
        FragmentItemActivity fragmentItem;

        fragmentItem = new FragmentItemActivity(); // because Fragment need new object each time
        fragmentItem.setPlaceImage(location.getLocationimageResourceID());
        String title = "\t\t" + ++position + "/" + getCount() + "\t\t\t\t" + location.getLocationName(); // to be as || 1/5 hotels ||
        fragmentItem.setPlaceName(title);
        fragmentItem.setPlaceAddress(location.getLocationAddress());
        fragmentItem.setPlaceDescription(location.getLocationDescription());

        return fragmentItem;
    }

    @Override
    public int getCount() {
        return count;
    }

    public void setLocations() {
        locations = new ArrayList<>();

        if (currentCategory.equals(mContext.getString(R.string.historical_places))) {
            setArray(R.array.historical_names, R.array.historical_address, R.array.historical_descriptions, R.array.historical_images);
        } else if (currentCategory.equals(mContext.getString(R.string.museums))) {
            setArray(R.array.museums_names, R.array.museums_address, R.array.museums_descriptions, R.array.museums_images);
        } else if (currentCategory.equals(mContext.getString(R.string.restaurants))) {
            setArray(R.array.restaurants_names, R.array.restaurants_address, R.array.restaurants_descriptions, R.array.restaurants_images);
        } else if (currentCategory.equals(mContext.getString(R.string.islamics))) {
            setArray(R.array.islamics_names, R.array.islamics_address, R.array.islamics_descriptions, R.array.islamics_images);
        } else if (currentCategory.equals(mContext.getString(R.string.copts))) {
            setArray(R.array.copts_names, R.array.copts_address, R.array.copts_descriptions, R.array.copts_images);
        } else if (currentCategory.equals(mContext.getString(R.string.beaches))) {
            setArray(R.array.beaches_names, R.array.beaches_address, R.array.beaches_descriptions, R.array.beaches_images);
        } else if (currentCategory.equals(mContext.getString(R.string.natural_places))) {
            setArray(R.array.natural_places_names, R.array.natural_places_address, R.array.natural_places_descriptions, R.array.natural_places_images);
        } else if (currentCategory.equals(mContext.getString(R.string.country))) {
            locations.add(new Location(mContext.getString(R.string.country), mContext.getString(R.string.country_address), mContext.getString(R.string.country_description), R.drawable.egy_orthographic));
        }
    }

    public void setArray(int nameResource, int addressResource, int descriptionResource, int imagesResources) {
        String[] names = mContext.getResources().getStringArray(nameResource);
        String[] address = mContext.getResources().getStringArray(addressResource);
        String[] descriptions = mContext.getResources().getStringArray(descriptionResource);
        final TypedArray images = mContext.getResources().obtainTypedArray(imagesResources);
        for (int i = 0; i < names.length; i++) {
            locations.add(new Location(names[i], address[i], descriptions[i], images.getResourceId(i, -1)));
        }
        images.recycle(); //Many resources, such as TypedArrays, VelocityTrackers, etc., should be recycled (with a recycle() call) after use. This lint check looks for missing recycle() calls
    }

}
