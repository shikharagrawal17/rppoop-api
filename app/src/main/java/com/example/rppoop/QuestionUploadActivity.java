package com.example.rppoop;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class QuestionUploadActivity extends AppCompatActivity {
    EditText question;
    EditText questionLink;
    EditText companyName;
    Button submit;
    ApiActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_upload);

        question = (EditText)findViewById(R.id.question);
        questionLink = (EditText)findViewById(R.id.questionLink);
        companyName = (EditText)findViewById(R.id.companyName);
        submit = findViewById(R.id.button);

        viewModel =new  ViewModelProvider(this).get(ApiActivityViewModel.class);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.uploadQuestion( companyName.getText().toString(), question.getText().toString(), questionLink.getText().toString());
            }
        });





    }
}