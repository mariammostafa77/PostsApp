package com.example.posts.postsScreen.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.posts.Communicator;
import com.example.posts.R;
import com.example.posts.model.Post;
import com.example.posts.model.Repository;
import com.example.posts.network.PostsClient;
import com.example.posts.postsScreen.presenter.PostsPresenter;
import com.example.posts.postsScreen.presenter.PostsPresenterInterface;
import com.example.posts.postsScreen.view.PostsAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;


public class PostsFragment extends Fragment implements PostsPresenterInterface {

    private PostsAdapter postsAdapter;
    private RecyclerView postsRecycle;
    private PostsPresenter postsPresenter;
    private FloatingActionButton floatingActionButton;
    private Communicator communicator;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_posts, container, false);
        initComponent(view);
        postsAdapter=new PostsAdapter();
        postsRecycle.setAdapter(postsAdapter);
        postsPresenter=new PostsPresenter(this, Repository.getInstance(PostsClient.getPostClient()));
        postsPresenter.getAllPosts();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                communicator = (Communicator) getActivity();
                communicator.goToAddPost();
            }
        });

        return view;
    }

    private void initComponent(View view){
        postsRecycle=view.findViewById(R.id.postsRecycle);
        floatingActionButton=view.findViewById(R.id.floatingActionButton);
    }

    @Override
    public void getAllPosts(List<Post> posts) {
        if(getArguments() != null){
            posts.add((Post) getArguments().getSerializable("newPost"));
        }
        postsAdapter.setUpdatedData(posts,getContext());
    }
}