package com.example.posts.network;

import com.example.posts.model.Comments;
import com.example.posts.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PostsService {

    @GET("/posts")
    Observable<List<Post>> getAllPosts(@Query("userId") int userId);
    @POST("/posts")
    Observable<Post> postNewPost(@Body Post post);

}
