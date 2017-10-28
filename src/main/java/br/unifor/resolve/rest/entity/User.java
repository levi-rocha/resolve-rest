package br.unifor.resolve.rest.entity;

import br.unifor.resolve.rest.util.MD5Encrypter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "users_id_seq")
    private Long id;

    @Column(nullable = false)
    @Size(min = 3, max = 20)
    private String username;

    @Column(nullable = false)
    @Size(min = 8)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @Column(nullable = false, unique = true)
    @Email
    private String email;

    @ManyToOne
    @Column(nullable = false)
    private Permission permission;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Post> posts;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<Solution> solutions;

	/* getters and setters */

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = MD5Encrypter.encrypt(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(Set<Solution> solutions) {
        this.solutions = solutions;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }
}