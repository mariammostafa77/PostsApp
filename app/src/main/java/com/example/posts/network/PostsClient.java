package com.example.posts.network;

import android.util.Log;

import com.example.posts.model.Comments;
import com.example.posts.model.Post;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;

public class PostsClient implements RemoteInterface {
    private static PostsClient postsClient;
    private PostsService postsService=RetrofitHelper.getRetrofit().create(PostsService.class);

    public static PostsClient getPostClient(){
        if(postsClient == null){
            postsClient=new PostsClient();
        }
        return postsClient;
    }

    @Override
    public Observable<List<Post>> getAllPosts(int userId) {
        return postsService.getAllPosts(userId);
    }

    @Override
    public Observable<Post> postNewPost(Post post) {
        return postsService.postNewPost(post);
    }


}
