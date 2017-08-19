package br.unifor.resolve.rest.dto;

import br.unifor.resolve.rest.entity.Permission;
import br.unifor.resolve.rest.entity.Post;
import br.unifor.resolve.rest.entity.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class UserDetailedDTO implements Serializable {

	private static final long serialVersionUID = -4334805450243911807L;

	private Long id;
	private String username;
	private String email;
	private Permission permission;
	private Set<PostSimpleDTO> posts;

	public static UserDetailedDTO fromUser(User user) {
		UserDetailedDTO dto = new UserDetailedDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setPermission(user.getPermission());
		Set<PostSimpleDTO> posts = new HashSet<>();
		if (user.getPosts() != null) {
			for (Post p : user.getPosts()) {
				PostSimpleDTO pdto = PostSimpleDTO.fromPost(p);
				posts.add(pdto);
			}
		}
		dto.setPosts(posts);
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Set<PostSimpleDTO> getPosts() {
		return posts;
	}

	public void setPosts(Set<PostSimpleDTO> posts) {
		this.posts = posts;
	}

}
