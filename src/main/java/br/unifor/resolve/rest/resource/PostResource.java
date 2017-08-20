package br.unifor.resolve.rest.resource;

import br.unifor.resolve.rest.entity.Post;
import br.unifor.resolve.rest.dto.PostUpdateFields;
import br.unifor.resolve.rest.entity.User;
import br.unifor.resolve.rest.dto.PostDetailedDTO;
import br.unifor.resolve.rest.dto.PostSimpleDTO;
import br.unifor.resolve.rest.dto.VoteDTO;
import br.unifor.resolve.rest.repository.PostRepository;
import br.unifor.resolve.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import org.springframework.data
        .domain.Pageable;

import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostResource {

	private PostRepository postRepository;
	private UserRepository userRepository;

	@Autowired
	public PostResource(PostRepository postRepository,
                        UserRepository userRepository) {
		this.postRepository = postRepository;
		this.userRepository = userRepository;
	}

	@RequestMapping(method = GET)
    public List<PostSimpleDTO> findAll(Pageable pageable) {
	    if (pageable != null && pageable.getSort() != null) {
            String sort = pageable.getSort().toString();
            if (sort != null && sort.toLowerCase().contains("votes")) {
                Iterable<Post> all = postRepository.findAll();
                List<PostSimpleDTO> dtos = new ArrayList<>();
                for (Post p : all) {
                    dtos.add(PostSimpleDTO.fromPost(p));
                }
                Collections.sort(dtos);
                int size = pageable.getPageSize();
                int offset = pageable.getOffset();
                if (size+offset > dtos.size()) {
                    size = dtos.size()-offset;
                }
                List<PostSimpleDTO> paged = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    paged.add(dtos.get(i+offset));
                }
                return paged;
            }
        }
	    Page<Post> page = postRepository.findAll(pageable);
	    if (page == null)
	        return null;
        List<PostSimpleDTO> posts = new ArrayList<>();
	    for (Post p : page.getContent()) {
            posts.add(PostSimpleDTO.fromPost(p));
        }
        return posts;
    }

    @RequestMapping(value="/search", method = GET)
    public List<PostSimpleDTO> findByKeywords(Pageable pageable,
            @RequestParam("keywords") String keywords) {
        Set<Post> allMatches = new HashSet<>();
        for (String key : keywords.split("[,]")) {
            List<Post> matches = postRepository
                    .findByContentContainingIgnoreCaseOrTitleContainingIgnoreCase(key, key);
            for (Post p : matches)
                allMatches.add(p);
        }
        List<PostSimpleDTO> dtos = new ArrayList<>();
        for (Post p : allMatches)
            dtos.add(PostSimpleDTO.fromPost(p));
        int size = 20;
        int offset = 0;
        if (pageable != null) {
            size = pageable.getPageSize();
            offset = pageable.getOffset();
            if (pageable.getSort() != null && pageable.getSort().toString()
                    .toLowerCase().contains("date")) {
                Collections.sort(dtos, new Comparator<PostSimpleDTO>() {
                    @Override
                    public int compare(PostSimpleDTO o1, PostSimpleDTO o2) {
                        return o1.getDate().compareTo(o2.getDate());
                    }
                });
            } else {
                Collections.sort(dtos);
            }
        } else {
            Collections.sort(dtos);
        }
        if (size+offset > dtos.size()) {
            size = dtos.size()-offset;
        }
        List<PostSimpleDTO> paged = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            paged.add(dtos.get(i+offset));
        }
        return paged;
    }

    @RequestMapping(value = "/{id}", method = GET)
    public PostDetailedDTO findById(
            @PathVariable Long id) {
        return PostDetailedDTO.fromPost(postRepository.findById(id));
    }

    @RequestMapping(method = POST)
    public PostDetailedDTO insert(@RequestBody Post post) {
        return PostDetailedDTO.fromPost(postRepository.save(post));
    }

    @RequestMapping(value = "/{id}", method = PATCH)
    public PostDetailedDTO update(@RequestBody PostUpdateFields post,
                                  @PathVariable Long id) {
        Post found = postRepository.findById(id);
        if (found == null)
            return null;
        if (post.getTitle() != null)
            found.setTitle(post.getTitle());
        if (post.getContent() != null)
            found.setContent(post.getContent());
        return PostDetailedDTO.fromPost(postRepository.save(found));
    }

    @RequestMapping(value = "/{id}", method = DELETE)
    public PostDetailedDTO delete(@PathVariable Long id) {
        return PostDetailedDTO.fromPost(postRepository
                .deleteById(id));
    }

    @RequestMapping(value = "/vote", method = POST)
    public PostDetailedDTO voteOnPost(@RequestBody VoteDTO vote) {
        User voter = userRepository.findByUsername(vote.getUsername());
        if (voter == null)
            return null;
        Post voted = postRepository.findById(vote.getPostId());
        if (voted == null)
            return null;
        Set<User> votes = voted.getVotes();
        votes.add(voter);
        voted.setVotes(votes);
        voted = postRepository.save(voted);
        return PostDetailedDTO.fromPost(voted);
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
