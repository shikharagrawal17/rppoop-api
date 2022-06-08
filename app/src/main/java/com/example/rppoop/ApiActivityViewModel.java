package com.example.rppoop;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ApiActivityViewModel extends AndroidViewModel {

    Repository repository ;
    public ApiActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public LiveData<List<QuestionModel>> getQuestions(String companyName){
        return repository.getQuestionModelMutableLiveData(companyName);
    }

    public void uploadQuestion(String companyName, String question, String questionLink){
        repository.uploadQuestion(question, questionLink, companyName);
        return;
    }
}
