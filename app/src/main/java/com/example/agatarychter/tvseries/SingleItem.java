package com.example.agatarychter.tvseries;

/**
 * Created by Agata Rychter on 26.03.2018.
 */

public class SingleItem {
    private String name;
    private String category;

    public SingleItem(String name, String category)
    {
        this.name = name;
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public String getCategory()
    {
        return category;
    }
}
