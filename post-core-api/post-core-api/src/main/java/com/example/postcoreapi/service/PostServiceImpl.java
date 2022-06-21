package com.example.postcoreapi.service;

import com.example.postcoreapi.model.PostModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    PostModel postModel;
    private static final HashMap<String, PostModel> postMap = new HashMap<>();

    static {
        PostModel postModel1 = new PostModel("post_id_1", "client_id_1",
                "post_recipient_id_1", "post_item_1", "on the way");
        PostModel postModel2 = new PostModel("post_id_2", "client_id_2",
                "post_recipient_id_2", "post_item_2", "on the way");
        PostModel postModel3 = new PostModel("post_id_3", "client_id_3",
                "post_recipient_id_3", "post_item_3", "on the way");

        postMap.put(postModel1.getPostId(), postModel1);
        postMap.put(postModel2.getPostId(), postModel2);
        postMap.put(postModel3.getPostId(), postModel3);
    }

    @Override
    public void sendPost(PostModel postModel) {
        postModel.setPostId(UUID.randomUUID().toString());
        postMap.put(postModel.getPostId(), postModel);
    }

    @Override
    public List<PostModel> getAllPosts() {
        return new ArrayList<>(postMap.values());
    }

    @Override
    public PostModel getPostById(String postId) {
        return postMap.get(postId);
    }

    @Override
    public void updatePostById(String postId, PostModel postModel) {
        postModel.setPostId(postId);
        postMap.put(postId, postModel);
    }

    @Override
    public void deletePostByClientId(String clientId) {
        postMap.remove(clientId);
    }
}
