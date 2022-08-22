package com.example.posts.model;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;

public interface RepoInterface {
    Observable<List<Post>> getAllPosts(int userId);
    Observable<Post> postNewPost( Post post);

}
