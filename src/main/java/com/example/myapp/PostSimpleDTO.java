package com.example.myapp;

import java.io.Serializable;
import java.util.Date;

public class PostSimpleDTO implements Serializable, Comparable<PostSimpleDTO> {

	private static final long serialVersionUID = 2355904530283938395L;

	private Long id;
	private String title;
	private String authorUsername;
	private int voteCount;
	private Date date;
	private String contentPreview;

	public static PostSimpleDTO fromPost(Post post) {
		PostSimpleDTO dto = new PostSimpleDTO();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setDate(post.getDate());
		if (post.getAuthor() != null)
			dto.setAuthorUsername(post.getAuthor().getUsername());
		if (post.getVotes() != null)
			dto.setVoteCount(post.getVotes().size());
		dto.setContentPreview(post.getContent());
		return dto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorUsername() {
		return authorUsername;
	}

	public void setAuthorUsername(String authorUsername) {
		this.authorUsername = authorUsername;
	}

	public int getVoteCount() {
		return voteCount;
	}

	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}

	public String getContentPreview() {
		return contentPreview;
	}

	public void setContentPreview(String contentPreview) {
		if (contentPreview != null) {
			if (contentPreview.length() > 140)
				this.contentPreview = contentPreview.substring(0, 137) + "...";
			else
				this.contentPreview = contentPreview;
		}
	}

	@Override
	public int compareTo(PostSimpleDTO o) {
		if (this.getVoteCount() > o.getVoteCount())
			return -1;
		else if (this.getVoteCount() < o.getVoteCount())
			return 1;
		else
			return 0;
	}
}
