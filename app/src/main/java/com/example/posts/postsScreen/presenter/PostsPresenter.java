package com.example.posts.postsScreen.presenter;

import android.util.Log;

import com.example.posts.model.Post;
import com.example.posts.model.RepoInterface;
import com.example.posts.model.Repository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsPresenter{
    private PostsPresenterInterface postsPresenterInterface;
    private RepoInterface repoInterface;
    private List<Post> posts=new ArrayList<Post>();

    public PostsPresenter(PostsPresenterInterface postsPresenterInterface, RepoInterface repoInterface) {
        this.postsPresenterInterface = postsPresenterInterface;
        this.repoInterface = repoInterface;
    }

    public void getAllPosts(){
        repoInterface.getAllPosts(2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts ->{
                    Log.i("TAG",posts.toString());
                    posts.addAll(posts);
                    postsPresenterInterface.getAllPosts(posts);}, error->{
                    Log.i("TAG",error.toString());
                } );
    }

}
