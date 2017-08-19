package br.unifor.resolve.rest.dto;

import br.unifor.resolve.rest.entity.Comment;
import br.unifor.resolve.rest.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

public class CommentDTO implements Serializable {

	private static final long serialVersionUID = 3069238842078018772L;

	private Long id;
	private String content;
	private Date date;
	private String authorUsername;
	private Long postId;

	public static CommentDTO fromComment(Comment comment) {
		CommentDTO dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setContent(comment.getContent());
		dto.setDate(comment.getDate());
		if (comment.getAuthor() != null)
			dto.setAuthorUsername(comment.getAuthor().getUsername());
		if (comment.getPost() != null)
			dto.setPostId(comment.getPost().getId());
		return dto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonSerialize(using=JsonDateSerializer.class)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}
}
