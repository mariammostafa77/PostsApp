package com.example.posts;

import com.example.posts.model.Post;

public interface Communicator {
    void goToAddPost();
    void backToPosts(Post post);
}
