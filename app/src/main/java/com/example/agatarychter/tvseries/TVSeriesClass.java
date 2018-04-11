package com.example.agatarychter.tvseries;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Agata Rychter on 01.04.2018.
 */

public class TVSeriesClass {
    private List<TVSeriesDef> list = new ArrayList<>();
    private ArrayList<Integer> screensGameOfThrones = new ArrayList<>();
    private ArrayList<Actor> actorsGameOfThrones = new ArrayList<>();
    private ArrayList<Integer> screensBreakingBad= new ArrayList<>();
    private ArrayList<Actor> actorsBreakingBad= new ArrayList<>();
    private ArrayList<Integer> screensGreysAnatomy= new ArrayList<>();
    private ArrayList<Actor> actorsGreysAnatomy = new ArrayList<>();
    private ArrayList<Integer> screensOnceUponATime = new ArrayList<>();
    private ArrayList<Actor> actorsOnceUponATime= new ArrayList<>();
    private ArrayList<Integer> screensWestworld = new ArrayList<>();
    private ArrayList<Actor> actorsWestworld= new ArrayList<>();
    private ArrayList<Integer> screensPeaky= new ArrayList<>();
    private ArrayList<Actor> actorsPeaky= new ArrayList<>();

    private TVSeriesClass() {
    }
    public List getTVSeriesList() {
        return list;
    }

    private Context context;
    private static final TVSeriesClass myInstance = new TVSeriesClass();

    public static TVSeriesClass getInstance() {
        return myInstance;
    }

    public void initialize(Context context)
    {
        this.context=context;
    }

    public Context getApplicationContext() {
        return context;
    }

    public void setTVSeries() {
        setGameOfThronesPhotosAndActors();
        setBreakingBadPhotosAndActors();
        setGreysAnatomyPhotosAndActors();
        setOnceUponATimePhotosAndActors();
        setWestworldPhotosAndActors();
        setPeakyBlindersPhotosAndActors();
        list.add(new TVSeriesDef(context.getResources().getString(R.string.game_of_thrones), context.getResources().getString(R.string.fantasy),R.drawable.got1,screensGameOfThrones,actorsGameOfThrones,R.color.scary));
        list.add(new TVSeriesDef(context.getResources().getString(R.string.breaking_bad), context.getResources().getString(R.string.criminal),R.drawable.break1,screensBreakingBad,actorsBreakingBad,R.color.scary));
        list.add(new TVSeriesDef(context.getResources().getString(R.string.greys_anatomy), context.getResources().getString(R.string.drama),R.drawable.ga,screensGreysAnatomy,actorsGreysAnatomy,R.color.medical));
        list.add(new TVSeriesDef(context.getResources().getString(R.string.once_upon), context.getResources().getString(R.string.fantasy),R.drawable.once,screensOnceUponATime,actorsOnceUponATime,R.color.fantasy));
        list.add(new TVSeriesDef(context.getResources().getString(R.string.westworld), context.getResources().getString(R.string.science_fiction),R.drawable.westworld,screensWestworld,actorsWestworld,R.color.science));
        list.add(new TVSeriesDef(context.getResources().getString(R.string.peaky_blinders), context.getResources().getString(R.string.historical_drama),R.drawable.peaky,screensPeaky,actorsPeaky,R.color.historical));
    }

    private void setGameOfThronesPhotosAndActors() {
        screensGameOfThrones.add(R.drawable.gots1);
        screensGameOfThrones.add(R.drawable.gots2);
        screensGameOfThrones.add(R.drawable.gots3);
        screensGameOfThrones.add(R.drawable.gots4);
        actorsGameOfThrones.add(new Actor(context.getResources().getString(R.string.emilia_clark).toString(),31,R.drawable.emilia_clark));
        actorsGameOfThrones.add(new Actor(context.getResources().getString(R.string.maisie_williams),21,R.drawable.maisie));
        actorsGameOfThrones.add(new Actor(context.getResources().getString(R.string.kit_harrington),32,R.drawable.kit));
        actorsGameOfThrones.add(new Actor(context.getResources().getString(R.string.sophie_turner),21,R.drawable.sansa));
        actorsGameOfThrones.add(new Actor(context.getResources().getString(R.string.peter_dinklage),48,R.drawable.tyrion));
    }

    private void setBreakingBadPhotosAndActors() {
        screensBreakingBad.add(R.drawable.bb1);
        screensBreakingBad.add(R.drawable.bb2);
        screensBreakingBad.add(R.drawable.bb3);
        screensBreakingBad.add(R.drawable.bb4);
        screensBreakingBad.add(R.drawable.bb5);
        screensBreakingBad.add(R.drawable.bb6);
        actorsBreakingBad.add(new Actor(context.getResources().getString(R.string.bryan_cranston),64,R.drawable.bb4));
        actorsBreakingBad.add(new Actor(context.getResources().getString(R.string.aaron_paul),34,R.drawable.bb6));
        actorsBreakingBad.add(new Actor(context.getResources().getString(R.string.dean_norris),59,R.drawable.bb2));
        actorsBreakingBad.add(new Actor(context.getResources().getString(R.string.giancario),62,R.drawable.giancario));
    }
    private void setGreysAnatomyPhotosAndActors() {
        screensGreysAnatomy.add(R.drawable.greys1);
        screensGreysAnatomy.add(R.drawable.greys2);
        screensGreysAnatomy.add(R.drawable.greys3);
        screensGreysAnatomy.add(R.drawable.greys4);
        screensGreysAnatomy.add(R.drawable.greys5);
        screensGreysAnatomy.add(R.drawable.greys6);
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.ellen_pompeo),42,R.drawable.ellen));
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.patrick_dempsey),49,R.drawable.patrick));
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.chandra_wilson),46,R.drawable.chandra_wilson));
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.jessie_williams),37,R.drawable.jessie_williams));
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.jessica_capshaw),35,R.drawable.jessica_capshaw));
        actorsGreysAnatomy.add(new Actor(context.getResources().getString(R.string.sarah_drew),40,R.drawable.sarah_drew));
    }
    private void setOnceUponATimePhotosAndActors() {
        screensOnceUponATime.add(R.drawable.once1);
        screensOnceUponATime.add(R.drawable.once2);
        screensOnceUponATime.add(R.drawable.once3);
        screensOnceUponATime.add(R.drawable.once4);
        screensOnceUponATime.add(R.drawable.once5);
        screensOnceUponATime.add(R.drawable.once6);
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.ginnifer),35,R.drawable.ginnifer));
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.jennifer),38,R.drawable.emma));
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.josh),39,R.drawable.charming));
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.colin),39,R.drawable.hook));
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.lana),41,R.drawable.lana));
        actorsOnceUponATime.add(new Actor(context.getResources().getString(R.string.jared),20,R.drawable.henry));
    }

    private void setWestworldPhotosAndActors() {
        screensWestworld.add(R.drawable.westworld1);
        screensWestworld.add(R.drawable.westworld2);
        screensWestworld.add(R.drawable.westworld3);
        screensWestworld.add(R.drawable.westworld4);
        screensWestworld.add(R.drawable.westworld5);
        screensWestworld.add(R.drawable.westworld6);
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.anthony),79,R.drawable.anthony));
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.james_marsden),36,R.drawable.james_marsden));
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.evan_rachel),32,R.drawable.dolores));
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.thandie),45,R.drawable.thandie));
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.jeffrey),48,R.drawable.jeffrey));
        actorsWestworld.add(new Actor(context.getResources().getString(R.string.angela),30,R.drawable.angela));
    }
    private void setPeakyBlindersPhotosAndActors() {
        screensPeaky.add(R.drawable.peaky1);
        screensPeaky.add(R.drawable.peaky2);
        screensPeaky.add(R.drawable.peaky3);
        screensPeaky.add(R.drawable.peaky4);
        screensPeaky.add(R.drawable.peaky5);
        screensPeaky.add(R.drawable.peaky6);
        actorsPeaky.add(new Actor(context.getResources().getString(R.string.cillian),38,R.drawable.cillian_murphy));
        actorsPeaky.add(new Actor(context.getResources().getString(R.string.annabelle),29,R.drawable.annabelle_wallis));
        actorsPeaky.add(new Actor(context.getResources().getString(R.string.adrien),42,R.drawable.adrien_brody));
        actorsPeaky.add(new Actor(context.getResources().getString(R.string.sam_neill),65,R.drawable.sam_neill));
        actorsPeaky.add(new Actor(context.getResources().getString(R.string.helen),58,R.drawable.helen_mccrory));
    }
}
