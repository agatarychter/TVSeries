package com.example.agatarychter.tvseries;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ActorsFragment extends Fragment {
    private ListViewAdapter adapter;
    private ArrayList<Actor> actorsList = new ArrayList<>();
    private static final String ACTORS = "Actors";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initArguments();
        View view = inflater.inflate(R.layout.fragment_actors2, container, false);
        initView(view);
        return view;
    }

    private void initArguments(){
        Intent intent = getActivity().getIntent();
        actorsList = intent.getParcelableArrayListExtra(ACTORS);
        if (getArguments() != null) {
            actorsList = getArguments().getParcelableArrayList(ACTORS);
        }
    }

    private void initView(View view){
        ListView listView = view.findViewById(R.id.list_view);
        adapter = new ListViewAdapter(getActivity());
        listView.setAdapter(adapter);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    class ListViewAdapter extends BaseAdapter {
        LayoutInflater layoutInflater;
        Context context;
        TextView name_txt;
        TextView age_txt;
        ImageView imageView;

        public ListViewAdapter(Context context){
            this.context = context;

        }
        @Override
        public int getCount() {
            return actorsList.size();
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
        public View getView(final int i, View newView, ViewGroup viewGroup) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view;
            if(newView==null)
            {
                newView = layoutInflater.inflate(R.layout.single_item,null);
            }
            view= newView;
            initViews(view);
            setElements(i);
            return view;
        }

        private void setElements(int i){
            Actor actor = actorsList.get(i);
            name_txt.setText(actor.getName());
            String age_info = actor.getAge() + "years ";
            age_txt.setText(age_info);
            imageView.setImageResource(actor.getPhoto());
        }

        private void initViews(View view){
            imageView = view.findViewById(R.id.fragment_icon);
            name_txt = view.findViewById(R.id.name_fragment);
            age_txt = view.findViewById(R.id.fragment_age);
        }
    }

}