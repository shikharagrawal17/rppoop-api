package com.example.rppoop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ApiActivity extends AppCompatActivity {

//    public ApiActivity(String companyName){
//        this.companyName = companyName;
//    }

    private ArrayList<QuestionModel> questionList;
    private RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;
    private ApiActivityViewModel apiActivityViewModel;
    private String companyName = "adobe";
//    private String companyName = ;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_api);
        button = findViewById(R.id.button2);
//        Bundle bundle = getIntent().getExtras();
//        String companyName = bundle.getString("companyName");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ApiActivity.this, QuestionUploadActivity.class);
                startActivity(i);
            }
        });
        apiActivityViewModel = new ViewModelProvider(this).get(ApiActivityViewModel.class);
        LoadQuestions(companyName);
    }

    public void LoadQuestions(String companyName){
        apiActivityViewModel.getQuestions(companyName).observe(this, new Observer<List<QuestionModel>>() {
            @Override
            public void onChanged(List<QuestionModel> questionModels) {
                questionList =(ArrayList<QuestionModel>)questionModels;
                showOnRecyclerView();
            }
        });
    }

    public void showOnRecyclerView(){
        recyclerView = findViewById(R.id.recyclerView);
        questionAdapter = new QuestionAdapter(this, questionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ApiActivity.this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(questionAdapter);
        questionAdapter.notifyDataSetChanged();
    }
}