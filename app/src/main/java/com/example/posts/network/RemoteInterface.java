package com.example.posts.network;

import com.example.posts.model.Comments;
import com.example.posts.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.Body;

public interface RemoteInterface {
    Observable<List<Post>> getAllPosts(int userId);
    Observable<Post> postNewPost( Post post);

}
