package com.example.agatarychter.tvseries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;


public class ScreensFragment extends Fragment {
    private ArrayList<Integer> photos = new ArrayList<>();
    private GridAdapter adapter;

    private static final String PHOTOS = "Screens";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_screens2, container, false);
        getFragmentArguments();
        setAdapterElements(view);
        return view;
    }

    private void setAdapterElements(View view){
        GridView gridView = view.findViewById(R.id.grid_view);
        adapter = new GridAdapter(getActivity());
        gridView.setAdapter(adapter);
    }

    private void getFragmentArguments(){
        Intent intent = getActivity().getIntent();
        photos = intent.getIntegerArrayListExtra(PHOTOS);
        if (getArguments() != null) {
            photos =getArguments().getIntegerArrayList(PHOTOS);
        }
    }


    class GridAdapter extends BaseAdapter {

        LayoutInflater layoutInflater;
        Context context;

        public GridAdapter(Context context) {
            this.context = context;
        }
        @Override
        public int getCount() {
            return photos.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View mV;
            if (view == null) {
                view = layoutInflater.inflate(R.layout.single_photo, null);
            }
            mV = view;
            setViewElems(view,i);
            return mV;
        }

        private void setViewElems(View view,int i){
            ImageView image = view.findViewById(R.id.photo_screens);
            image.setImageResource(photos.get(i));
        }
    }
}

