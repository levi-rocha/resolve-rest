package br.unifor.resolve.rest.dto;

import br.unifor.resolve.rest.util.JsonDateSerializer;
import br.unifor.resolve.rest.entity.Solution;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.Date;

public class SolutionDTO implements Serializable {

    private Long id;
    private String content;
    private Date date;
    private String authorUsername;
    private Long postId;

    public static SolutionDTO fromSolution(Solution solution) {
        SolutionDTO dto = new SolutionDTO();
        dto.setId(solution.getId());
        dto.setContent(solution.getContent());
        dto.setDate(solution.getDate());
        if (solution.getAuthor() != null)
            dto.setAuthorUsername(solution.getAuthor().getUsername());
        if (solution.getPost() != null)
            dto.setPostId(solution.getPost().getId());
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
