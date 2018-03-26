package com.example.agatarychter.tvseries;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    private List<SingleItem> itemList;
    private int [] IMAGES = {R.drawable.break1,R.drawable.ga, R.drawable.got1, R.drawable.peaky,R.drawable.once,R.drawable.hannibal};
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initAdapterElements();
    }

    private void initViews() {
        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        itemList = new ArrayList<>();
        initItems();
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initAdapterElements()
    {
        adapter = new MyAdapter(itemList,getApplicationContext());
        recyclerView.setAdapter(adapter);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new RecyclerItemTouchHelper(0, ItemTouchHelper.LEFT,  this);
        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
    }

    private void initItems() {
        itemList.add(new SingleItem("Breaking bad", "Criminal"));
        itemList.add(new SingleItem("Grey's Anatomy","Drama"));
        itemList.add(new SingleItem("Game of Thrones","Fantasy"));
        itemList.add(new SingleItem("Peaky Blinders","Historical drama"));
        itemList.add(new SingleItem("Once upon a time","Fantasy"));
        itemList.add(new SingleItem("Hannibal","Horror"));
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof MyAdapter.MyViewHolder) {
            String name = itemList.get(viewHolder.getAdapterPosition()).getName();
            adapter.removeItem(viewHolder.getAdapterPosition());
        }
    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private List<SingleItem> list;
        public MyAdapter(List<SingleItem> list, Context context)
        {
            this.list = list;
        }

        class MyViewHolder extends RecyclerView.ViewHolder{
            private TextView name;
            private TextView category;
            private ImageView photo;
            public ConstraintLayout viewForeground;

            public MyViewHolder(View itemView) {
                super(itemView);
                initViews();
                initListener();
            }

            private void initListener()
            {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Context context = view.getContext();
                        Intent intent = new Intent(context, Description.class);
                        Description.start(getApplicationContext(),name.getText().toString(),category.getText().toString(),R.drawable.bb);
                        context.startActivity(intent);
                    }
                });
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
        public void onBindViewHolder(MyViewHolder holder, int position) {
            SingleItem singleItem = list.get(position);
            holder.name.setText(singleItem.getName());
            holder.category.setText(singleItem.getCategory());
            holder.photo.setImageResource(IMAGES[position]);

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


