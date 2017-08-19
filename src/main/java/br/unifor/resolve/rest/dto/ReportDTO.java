package br.unifor.resolve.rest.dto;

import br.unifor.resolve.rest.entity.Report;

import java.io.Serializable;

public class ReportDTO implements Serializable {

    private Long id;
    private String authorUsername;
    private String description;
    private PostSimpleDTO post;

    public static ReportDTO fromReport(Report report) {
        ReportDTO dto = new ReportDTO();
        dto.setId(report.getId());
        dto.setDescription(report.getDescription());
        if (report.getAuthor() != null)
            dto.setAuthorUsername(report.getAuthor().getUsername());
        if (report.getPost() != null)
            dto.setPost(PostSimpleDTO.fromPost(report.getPost()));
        return dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String username) {
        this.authorUsername = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PostSimpleDTO getPost() {
        return post;
    }

    public void setPost(PostSimpleDTO post) {
        this.post = post;
    }
}
