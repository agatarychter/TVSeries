package com.example.agatarychter.tvseries;
import android.os.Parcel;
import android.os.Parcelable;
/**
 * Created by Agata Rychter on 02.04.2018.
 */

public class Actor implements Parcelable {
    private String name;
    private int age;
    private int photo;

    public Actor(Parcel input)
    {
        name = input.readString();
        age = input.readInt();
        photo = input.readInt();
    }
    public Actor(String name, int age, int photo)
    {
        this.name = name;
        this.age = age;
        this.photo = photo;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getPhoto() {
        return photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeInt(this.age);
        parcel.writeInt(this.photo);
    }

    public static final Parcelable.Creator<Actor> CREATOR
            = new Parcelable.Creator<Actor>() {
        public Actor createFromParcel(Parcel in) {
            return new Actor(in);
        }

        public Actor[] newArray(int size) {
            return new Actor[size];
        }
    };
}
