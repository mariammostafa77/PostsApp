package com.example.posts.addNewPost.presenter;

import android.util.Log;

import com.example.posts.model.Post;
import com.example.posts.model.Repository;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AddPostPresenter {
    private AddPostPresenterInterface addPostPresenterInterface;
    private Repository repository;

    public AddPostPresenter(AddPostPresenterInterface addPostPresenterInterface, Repository repository) {
        this.addPostPresenterInterface = addPostPresenterInterface;
        this.repository = repository;
    }

    public void postNewPost(String title, String body){
        Post post=new Post(2,title,body);
        repository.postNewPost(post)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newPost ->{
            addPostPresenterInterface.addPost(newPost);
            Log.i("TAG",newPost.getTitle());
        }, error->{
            Log.i("TAG",error.toString());
        } );
    }
}
