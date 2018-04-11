package com.example.agatarychter.tvseries;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Description extends AppCompatActivity {
    private TextView name;
    private TextView category;
    private ImageView photo;
    private RelativeLayout myLayout;

    private Button actor_button;
    private Button screen_button;

    private Fragment actorsFragment;
    private Fragment screensFragment;

    private ArrayList<Actor> actorList;
    private ArrayList<Integer> screensList;

    private static final String TITLE = "Title";
    private static final String CATEGORY = "Category";
    private static final String IMAGE = "Image";
    private static final String ACTORS= "Actors";
    private static final String SCREENS_LIST = "Screens";
    private static final String COLOR = "Color";

    private static final String ACTORS_FR= "Actors fragment";
    private static final String SCREENS_FR = "Screens fragment";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        initViews();
        setViews();
        initFragment(savedInstanceState);
        initClick();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    private void initFragment(Bundle savedInstanceState) {
       if (savedInstanceState==null) {
            actorsFragment = new ActorsFragment();
            screensFragment = new ScreensFragment();

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.contener,actorsFragment,ACTORS_FR);
            fragmentTransaction.detach(actorsFragment);
            fragmentTransaction.add(R.id.contener,screensFragment,SCREENS_FR);
            fragmentTransaction.detach(screensFragment);
            fragmentTransaction.commit();
        }
        else {
            actorsFragment = getFragmentManager().findFragmentByTag(ACTORS_FR);
            screensFragment = getFragmentManager().findFragmentByTag(SCREENS_FR);
        }
    }

    private void initClick() {
        actor_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.attach(actorsFragment);
                fragmentTransaction.detach(screensFragment);
                fragmentTransaction.commit();
            }
        });
        screen_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.attach(screensFragment);
                fragmentTransaction.detach(actorsFragment);
                fragmentTransaction.commit();
            }
        });
    }
    private void setViews() {
        Intent intent = getIntent();
        name.setText(intent.getStringExtra(TITLE));
        category.setText(intent.getStringExtra(CATEGORY));
        photo.setImageResource(intent.getIntExtra(IMAGE,0));
        actorList = intent.getParcelableArrayListExtra(ACTORS);
        screensList = intent.getIntegerArrayListExtra(SCREENS_LIST);
        myLayout.setBackgroundColor(getResources().getColor(intent.getIntExtra(COLOR,0)));
    }

    private void initViews(){
        name = findViewById(R.id.title);
        category = findViewById(R.id.genre);
        photo = findViewById(R.id.photo);
        actor_button = findViewById(R.id.button_actors);
        screen_button = findViewById(R.id.button_screens);
        FrameLayout contener = findViewById(R.id.contener);
        myLayout = findViewById(R.id.desc_layout);
    }

    public static void start(Context context,String title,String category, int image, ArrayList<Integer> screensList, ArrayList<Actor> actorList,int color) {
        Intent starter = new Intent(context, Description.class);
        starter.putExtra(TITLE,title);
        starter.putExtra(CATEGORY,category);
        starter.putExtra(IMAGE,image);
        starter.putExtra(SCREENS_LIST,screensList);
        starter.putExtra(ACTORS,actorList);
        starter.putExtra(COLOR,color);
        context.startActivity(starter);
    }
}
