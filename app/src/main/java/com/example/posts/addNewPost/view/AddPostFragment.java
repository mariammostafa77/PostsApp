package com.example.posts.addNewPost.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.posts.Communicator;
import com.example.posts.R;
import com.example.posts.addNewPost.presenter.AddPostPresenterInterface;
import com.example.posts.addNewPost.presenter.AddPostPresenter;
import com.example.posts.model.Post;
import com.example.posts.model.Repository;
import com.example.posts.network.PostsClient;

public class AddPostFragment extends Fragment implements AddPostPresenterInterface {

    private EditText etTitle ,etBody;
    private Button btnSubmit;
    private AddPostPresenter addPostPresenter;
    private Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("TAG","hello");
        View view=inflater.inflate(R.layout.fragment_add_post, container, false);
        initComponent(view);
        communicator=(Communicator)getActivity();
        addPostPresenter=new AddPostPresenter( this,Repository.getInstance(PostsClient.getPostClient()));
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!etTitle.getText().toString().isEmpty() && !etBody.getText().toString().isEmpty() ){
                    addPostPresenter.postNewPost(etTitle.getText().toString(),etBody.getText().toString());
                }else{
                    Toast.makeText(getContext(),"All fields required",Toast.LENGTH_LONG).show();
                }

            }
        });
        return view;
    }

    private void initComponent(View view){
        etTitle = view.findViewById(R.id.etTitle);
        etBody=view.findViewById(R.id.etBody);
        btnSubmit=view.findViewById(R.id.btnSubmit);
    }

    @Override
    public void addPost(Post post) {
        communicator.backToPosts(post);
    }
}