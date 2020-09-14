package com.dev.profileapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.profileapp.Modal.Post;
import com.dev.profileapp.R;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<Post> postList;

    public PostAdapter() {
        postList = new ArrayList<>();
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
        super.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_view , parent , false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        Post post = postList.get(position);
        if (post != null)
        {
            holder.postTitle.setText(post.getTitle());
            holder.postDesc.setText(post.getDesc());
        }
    }

    @Override
    public int getItemCount() {
        if (postList.size() == 0)
            return 0;

        return postList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        MaterialTextView postTitle , postDesc;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postTitle = itemView.findViewById(R.id.post_title_tv);
            postDesc = itemView.findViewById(R.id.post_desc_tv);
        }
    }
}
