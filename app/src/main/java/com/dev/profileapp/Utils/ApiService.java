package com.dev.profileapp.Utils;


import com.dev.profileapp.Modal.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> postList();

}
