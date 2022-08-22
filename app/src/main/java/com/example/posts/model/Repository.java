package com.example.posts.model;

import android.content.Context;
import android.util.Log;

import com.example.posts.network.RemoteInterface;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements RepoInterface{
    private Context context;
    private RemoteInterface remoteInterface;
    private static Repository repository;

    private Repository(RemoteInterface remoteInterface) {
        this.remoteInterface=remoteInterface;
    }

    public static Repository getInstance(RemoteInterface remoteInterface){
        if(repository == null){
            repository = new Repository(remoteInterface);
        }
        return repository;
    }
    @Override
    public Observable<List<Post>> getAllPosts(int userId) {
        return remoteInterface.getAllPosts(userId);
    }

    @Override
    public Observable<Post> postNewPost(Post post) {
        return remoteInterface.postNewPost(post);
    }

}
