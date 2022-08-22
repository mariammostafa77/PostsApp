package com.example.posts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.posts.addNewPost.view.AddPostFragment;
import com.example.posts.model.Post;
import com.example.posts.postsScreen.view.PostsFragment;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragmentWithoutAddToBackStack(new PostsFragment());
    }
    private void replaceFragmentWithoutAddToBackStack(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.container,fragment,null);
        transaction.commit();
    }

    private void replaceFragmentWithAddToBackStack(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setReorderingAllowed(true);
        transaction.replace(R.id.container,fragment,null);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }

    @Override
    public void goToAddPost() {
        replaceFragmentWithAddToBackStack(new AddPostFragment());
    }

    @Override
    public void backToPosts(Post post) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("newPost",post);
        PostsFragment postsFragment=new PostsFragment();
        postsFragment.setArguments(bundle);
        getSupportFragmentManager().popBackStack();
        replaceFragmentWithoutAddToBackStack(postsFragment);
    }
}