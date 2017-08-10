package com.example.myapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.data
        .domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostResource {

	private PostRepository postRepository;

	@Autowired
	public PostResource(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@RequestMapping(method = GET)
    public List<PostSimpleDTO> findAllPosts(Pageable pageable) {
	    String sort = pageable.getSort().toString();
	    if (sort != null && sort.toLowerCase().contains("votes")) {
            Iterable<Post> all = postRepository.findAll();
            List<PostSimpleDTO> dtos = new ArrayList<>();
            for (Post p : all) {
                dtos.add(PostSimpleDTO.fromPost(p));

            }
            Collections.sort(dtos);
            List<PostSimpleDTO> paged = new ArrayList<>();
            for (int i = 0; i < pageable.getPageSize(); i++) {
                paged.add(dtos.get(i+pageable.getOffset()));
            }
            return paged;
        }
	    Page<Post> page = postRepository.findAll(pageable);
	    if (page == null)
	        // Replace with exception
	        return null;
        List<PostSimpleDTO> posts = new ArrayList<>();
	    for (Post p : page.getContent()) {
            posts.add(PostSimpleDTO.fromPost(p));
        }
        return posts;
    }

	/*

	@RequestMapping(value = "/{id}", method = GET)
	public Response findPostById(@PathVariable(value="id") Long id) {
		try {
			Post post = postRepository.findById(id);
			PostDetailedDTO data = PostDetailedDTO.fromPost(post);
			return Response.ok(data, MediaType.APPLICATION_JSON).build();
		} catch (ChangeSetPersister.NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(e.getMessage()).build();
		}
	}

	public Response listPosts(@QueryParam("q") int quantity,
							  @QueryParam("c") String criteria,
							  @QueryParam("s") int start,
							  @QueryParam("k") String keywords) {
		List<PostSimpleDTO> data = postBO.listPosts(
				quantity, start, criteria, keywords);
		return Response.ok(data, MediaType.APPLICATION_JSON).build();
	}

	public Response addPost(Post post) {
		try {
			PostDetailedDTO data = postBO.addPost(post);
			return Response.ok(data, MediaType.APPLICATION_JSON).build();
		} catch (InvalidArgumentException e) {
			return Response.status(422).entity(e.getMessage()).build();
		} catch (NotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage()).build();
        }
    }

	public Response updatePost(Post post) {
		try {
			PostDetailedDTO data = postBO.updatePost(post);
			return Response.ok(data, MediaType.APPLICATION_JSON).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(e.getMessage()).build();
		} catch (ServerException e) {
			return Response.serverError().entity(e.getMessage()).build();
		} catch (InvalidArgumentException e) {
			return Response.status(422).entity(e.getMessage()).build();
		}
	}

	public Response removePost(@PathParam("id") Long id) {
		try {
			PostDetailedDTO data = postBO.removePost(id);
			return Response.ok(data, MediaType.APPLICATION_JSON).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(e.getMessage()).build();
		} catch (ServerException e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

	public Response voteOnPost(VoteDTO vote) {
		try {
			PostDetailedDTO data = postBO.voteOnPost(vote);
			return Response.ok(data, MediaType.APPLICATION_JSON).build();
		} catch (NotFoundException e) {
			return Response.status(Response.Status.NOT_FOUND)
					.entity(e.getMessage()).build();
		} catch (ServerException e) {
			return Response.serverError().entity(e.getMessage()).build();
		} catch (InvalidArgumentException e) {
			return Response.status(422).entity(e.getMessage()).build();
		}
	}

	*/
}
