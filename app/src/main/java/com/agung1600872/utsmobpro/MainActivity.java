package com.agung1600872.utsmobpro;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView rvCategory;
    private ArrayList<Result> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);
        list = new ArrayList<>();
        list.addAll(MovieRepo.getListData());
        showRecyclerCardView();
    }
    private void showRecyclerCardView(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewMovieAdapter cardViewMovieAdapter = new
                CardViewMovieAdapter(this);
        cardViewMovieAdapter.setListMovie(list);
        rvCategory.setAdapter(cardViewMovieAdapter);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_set_detail:
                Intent moveIntent = new Intent(MainActivity.this,detailFilm.class);
                startActivity(moveIntent);
                break;
        }
    }

}
