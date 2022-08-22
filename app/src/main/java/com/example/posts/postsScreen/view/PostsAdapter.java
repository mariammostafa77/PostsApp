package com.example.posts.postsScreen.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.posts.R;
import com.example.posts.model.Post;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private List<Post> allPosts;
    private Context context;

    public void setUpdatedData(List<Post> allPosts, Context context) {
        this.allPosts = allPosts;
        this.context = context;
        notifyDataSetChanged();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvPostBody,tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPostBody=itemView.findViewById(R.id.tvPostBody);
            tvTitle=itemView.findViewById(R.id.tvTitle);
        }

        public void onBind(){
            tvPostBody.setText(allPosts.get(getPosition()).getBody());
            tvTitle.setText(allPosts.get(getPosition()).getTitle());
        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.post_layout,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind();
    }

    @Override
    public int getItemCount() {
        if(allPosts == null){
            return 0;
        }
        return allPosts.size();
    }
}
