package com.example.myapp;


import java.io.Serializable;

public class VoteDTO implements Serializable {

    private Long postId;
    private String username;

    public VoteDTO() {

    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
