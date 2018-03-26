package com.example.agatarychter.tvseries;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Description extends AppCompatActivity {
    private TextView name;
    private TextView category;
    private ImageView photo;

    private static final String TITLE = "Title";
    private static final String CATEGORY = "Category";
    private static final String IMAGE = "Image";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        initViews();
        setViews();
    }

    private void setViews() {
        Intent intent = getIntent();
        name.setText(intent.getStringExtra(TITLE));
        category.setText(intent.getStringExtra(CATEGORY));
        photo.setImageResource(intent.getIntExtra(IMAGE,0));
    }

    private void initViews(){
        name = findViewById(R.id.title);
        category = findViewById(R.id.genre);
        photo = findViewById(R.id.photo);
    }

    public static void start(Context context,String title, String category, int image) {
        Intent starter = new Intent(context, Description.class);
        starter.putExtra(TITLE,title);
        starter.putExtra(CATEGORY,category);
        starter.putExtra(IMAGE,image);
        context.startActivity(starter);
    }
}
