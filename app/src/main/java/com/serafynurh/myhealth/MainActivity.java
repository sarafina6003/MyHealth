package com.serafynurh.myhealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements TextWatcher{
    GridView grid;
    int images[] ={R.mipmap.apple,R.mipmap.apricots,R.mipmap.artichokes,R.mipmap.asparagus,R.mipmap.avocado,R.mipmap.bananas,R.mipmap.beets,R.mipmap.broccoli,R.mipmap.brusselsprouts,R.mipmap.cabbages,R.mipmap.cantaloupe,R.mipmap.carrots,R.mipmap.cauliflower,R.mipmap.celery,R.mipmap.coconutwater,R.mipmap.coriander,R.mipmap.corn,R.mipmap.courgettes,R.mipmap.cowpeas,R.mipmap.cranberry,R.mipmap.cucumber,R.mipmap.dates,R.mipmap.eggplant,R.mipmap.figs,R.mipmap.garlic,R.mipmap.grapefruit, R.mipmap.grapes,R.mipmap.greenpeas,R.mipmap.kales,R.mipmap.leeks,R.mipmap.lemon,R.mipmap.lettuce,R.mipmap.mangofruit,R.mipmap.mint,R.mipmap.mushrooms,R.mipmap.okra,R.mipmap.onions,R.mipmap.orangefruit,R.mipmap.parsnips,R.mipmap.pears,R.mipmap.peasprouts,R.mipmap.pumpkins,R.mipmap.radishes,R.mipmap.spinach,R.mipmap.spirulina,R.mipmap.squash,R.mipmap.strawberry,R.mipmap.sunflowersprouts,R.mipmap.sweetpotatoes,R.mipmap.swisschard,R.mipmap.tangerine,R.mipmap.tofu,R.mipmap.tomatoes,R.mipmap.turmeric,R.mipmap.waterchestnuts,R.mipmap.watercress,R.mipmap.watermelon,R.mipmap.wheatgrass,R.mipmap.yam,R.mipmap.zucchini};
    String[] titles ={"Apples", "Apricots", "Artichokes", "Asparagus", "Avocadoes", "Bananas", "Beets", "Broccoli", "Brussel Sprouts", "Cabbages", "Cantaloupe", "Carrots", "Cauliflower", "Celery", "Coconut Water", "Coriander", "Corn", "Courgettes", "Cow peas", "Cranberries", "Cucumber", "Dates", "Eggplant", "Figs", "Garlic", "Grapefruit", "Grapes", "Green peas", "Kales", "Leeks", "Lemon", "Lettuce", "Mango Fruit", "Mint", "Mushrooms", "Okra", "Onions", "Orange Fruit", "Parsnips", "Pears", "Pea sprouts", "Pumpkins", "Radishes", "Spinach", "Spirulina", "Squash", "Strawberry", "Sunflower sprouts", "Sweet Potatoes", "Swiss Chard", "Tangerine", "Tofu", "Tomatoes", "Turmeric", "Water Chestnuts", "Watercress", "Watermelon", "Wheat Grass", "Yam", "Zucchini"};
    ArrayList<Item> originalItems;

    CustomAdapter customAdapter;


    ArrayList<String> data;
    ArrayList<String> searchResults;
    ImageAdapter adapter;
    EditText searchEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        grid = (GridView) findViewById(R.id.my_health);
        searchEditText= (EditText) findViewById(R.id.editTextSearch);

        originalItems=new ArrayList<>();

        for (int i=0; i<titles.length; i++){
            originalItems.add(new Item(titles[i], images[i]));
        }
        customAdapter =new CustomAdapter(this, originalItems);

        grid.setAdapter(customAdapter);

/*        data=new ArrayList<>();
        data.addAll(Arrays.asList(titles));
        searchResults=new ArrayList<>();
        searchResults=data;

        adapter = new ImageAdapter(this, images,searchResults);
        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent a = new Intent(MainActivity.this, DetailsActivity.class);
                a.putExtra("data", position);
                startActivity(a);
            }
        });*/

        searchEditText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
         customAdapter.filter(s.toString());
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}