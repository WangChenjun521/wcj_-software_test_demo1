package com.fdu.wcjproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private  SearchAdapter mSearchAdapter=new SearchAdapter();
    private Button buttonSearch;
    private TextView textSearch;
    private  List<String> outputList=new ArrayList<>();
    private List<String> items=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        for(int i=0;i<100;i++){
            items.add("这个数字是"+String.valueOf(i));
        }
        buttonSearch =(Button)findViewById(R.id.btnSearch);
        textSearch=(TextView)findViewById(R.id.textSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                outputList.clear();
                String str=textSearch.getText().toString();
                for (int i=0;i<items.size();i++){
                    int index =items.get(i).indexOf(str,0);
                    if(index!=-1){
                        outputList.add(items.get(i));
                    }
                }
                mSearchAdapter.notifyItems(outputList);
            }
            });
        mRecyclerView=findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mRecyclerView.getContext()));
        mRecyclerView.setAdapter(mSearchAdapter);

    }



}
