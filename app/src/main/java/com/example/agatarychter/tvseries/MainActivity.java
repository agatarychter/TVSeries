package com.example.agatarychter.tvseries;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerItemTouchHelper.RecyclerItemTouchHelperListener{
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<TVSeriesDef> itemList;
    private static final String FILM_LIST = "FILM_LIST";
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
       if(savedInstanceState==null) {
           initItems();
       }
       else {
           itemList = savedInstanceState.getParcelableArrayList(FILM_LIST);
       }
       initAdapterElements();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void initAdapterElements() {
        adapter = new MyAdapter(itemList,getApplicationContext());
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT,  this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(FILM_LIST, (ArrayList<? extends Parcelable>) itemList);
    }

    private void initItems() {
        TVSeriesClass tvSeries = TVSeriesClass.getInstance();
        tvSeries.getInstance().initialize(this);
        tvSeries.setTVSeries();
        itemList = tvSeries.getTVSeriesList();
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MyAdapter.MyViewHolder) {
            adapter.removeItem(viewHolder.getAdapterPosition());
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private List<TVSeriesDef> list;
        private Context context;
        public MyAdapter(List<TVSeriesDef> list, Context context) {
            this.list = list;
            this.context = context;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView name;
            private TextView category;
            private ImageView photo;
            public ConstraintLayout viewForeground;

            public MyViewHolder(View itemView) {
                super(itemView);
                initViews();

            }
            private void initViews() {
                name = (TextView)itemView.findViewById(R.id.name);
                category=(TextView)itemView.findViewById(R.id.category);
                photo = (ImageView)itemView.findViewById(R.id.logo_photo);
                viewForeground = itemView.findViewById(R.id.view_foreground);
            }
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            final TVSeriesDef singleItem = list.get(position);
            holder.name.setText(singleItem.getName());
            holder.category.setText(singleItem.getGenre());
            holder.photo.setImageResource(singleItem.getImageResource());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Description.start(view.getContext(),singleItem.getName(),singleItem.getGenre(),singleItem.getImageResource(),singleItem.getScreens(),singleItem.getActors(),singleItem.getColor());
                }
            });

        }
        private void removeItem(int position) {
            list.remove(position);
            notifyItemRemoved(position);
        }
        @Override
        public int getItemCount() {
            return list.size();
        }
    }
}


