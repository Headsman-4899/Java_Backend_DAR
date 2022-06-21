package com.example.postcoreapi.service;


import com.example.postcoreapi.model.PostModel;

import java.util.List;

public interface PostService {
    void sendPost(PostModel postModel);
    List<PostModel> getAllPosts();
    PostModel getPostById(String postId);
    void updatePostById(String postId, PostModel postModel);
    void deletePostByClientId(String clientId);
}
