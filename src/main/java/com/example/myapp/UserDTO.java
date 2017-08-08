package com.example.myapp;

import java.util.ArrayList;
import java.util.List;

public class UserDTO {

    private String username;
    private String email;
    private String permissionName;
    private List<Long> postIds;

    public static UserDTO fromUser(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPermissionName(user.getPermission().getName());
        List<Long> postIds = new ArrayList<>();
        for (Post p : user.getPosts()) {
            postIds.add(p.getId());
        }
        dto.setPostIds(postIds);
        return dto;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Long> postIds) {
        this.postIds = postIds;
    }
}
