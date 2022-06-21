package com.example.postcoreapi.controller;

import com.example.postcoreapi.model.PostModel;
import com.example.postcoreapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<String> sendPost(@Valid @RequestBody PostModel postModel) {
        postService.sendPost(postModel);
        postModel.setStatus("sent");
        return new ResponseEntity<>("Successfully sent!", HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> changePostById(@PathVariable String postId,
                                                 @Valid @RequestBody PostModel postModel) {
        postService.updatePostById(postId, postModel);
        return new ResponseEntity<>("Successfully updated!", HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<PostModel> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public PostModel getStatusPostById(@PathVariable String postId) {
        return postService.getPostById(postId);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deletePostById(@PathVariable String clientId) {
        postService.deletePostByClientId(clientId);
        return new ResponseEntity<>("Successfully deleted!", HttpStatus.OK);
    }
}
