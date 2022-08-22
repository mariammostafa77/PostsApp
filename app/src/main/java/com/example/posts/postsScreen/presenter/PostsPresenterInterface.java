package com.example.posts.postsScreen.presenter;


import com.example.posts.model.Post;

import java.util.List;

import retrofit2.Call;

public interface PostsPresenterInterface {
    void getAllPosts(List<Post>posts);
}
