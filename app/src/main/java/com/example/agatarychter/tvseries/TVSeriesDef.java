package com.example.agatarychter.tvseries;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata Rychter on 01.04.2018.
 */
public class TVSeriesDef implements Parcelable {
    private String name;
    private String genre;
    private int imageResource;
    private int color;
    private ArrayList<Integer> screens;
    private ArrayList<Actor> actors;

    public TVSeriesDef(String name, String genre, int imageResource, ArrayList<Integer> screens,ArrayList<Actor>actors, int color){
        this.name = name;
        this.genre = genre;
        this.imageResource = imageResource;
        this.actors = actors;
        this.screens = screens;
        this.color = color;
    }

    public TVSeriesDef(Parcel input)
    {
        name = input.readString();
        imageResource = input.readInt();
        genre = input.readString();
        actors = input.readArrayList(TVSeriesDef.class.getClassLoader());
        screens = input.readArrayList(Integer.class.getClassLoader());
    }

    public String getName()
    {
        return name;
    }

    public String getGenre(){
        return genre;
    }

    public int getImageResource()
    {
        return imageResource;
    }

    public int getColor(){ return color;}

    public ArrayList<Actor> getActors()
    {
        return actors;
    }

    public ArrayList<Integer> getScreens()
    {
        return screens;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.imageResource);
        parcel.writeString(this.genre);
        parcel.writeList(this.actors);
        parcel.writeList(this.screens);
    }


    public static final Parcelable.Creator<TVSeriesDef> CREATOR
            = new Parcelable.Creator<TVSeriesDef>() {
        public TVSeriesDef createFromParcel(Parcel in) {
            return new TVSeriesDef(in);
        }

        public TVSeriesDef[] newArray(int size) {
            return new TVSeriesDef[size];
        }
    };
}
