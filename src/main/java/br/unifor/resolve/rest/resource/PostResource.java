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
import org.springframework.transaction.annotation.Transactional;
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
	    if (isVoteSort(pageable))
            return dtosSortedByVotes(pageable, postRepository.findAll());
        else
            return dtosFromPage(postRepository.findAll(pageable));
    }

    @RequestMapping(value="/search", method = GET)
    public List<PostSimpleDTO> findByKeywords(Pageable pageable,
            @RequestParam("keywords") String keywords) {
        List<Post> allMatches = new ArrayList<>();
        for (String key : keywords.split("[,]")) {
            List<Post> matches = postRepository
                    .findDistinctByContentContainingIgnoreCaseOrTitleContainingIgnoreCase(key, key);
            for (Post p : matches)
                allMatches.add(p);
        }
        if (isVoteSort(pageable))
            return dtosSortedByVotes(pageable, allMatches);
        else {
            List<Long> ids = new ArrayList<>();
            for (Post p : allMatches)
                ids.add(p.getId());
            return dtosFromPage(postRepository.findByIdIn(pageable, ids));
        }
    }

    @RequestMapping(value = "/{id}", method = GET)
    public PostDetailedDTO findById(
            @PathVariable Long id) {
        return PostDetailedDTO.fromPost(postRepository.findById(id));
    }

    @RequestMapping(method = POST)
    public PostDetailedDTO insert(@RequestBody Post post) {
	    User author = userRepository.findByUsername(
	            post.getAuthor().getUsername());
	    post.setAuthor(author);
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
    public Long delete(@PathVariable Long id) {
        return postRepository.deleteById(id);
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

    @RequestMapping(value="/byAuthor/{id}", method = GET)
    public List<PostSimpleDTO> findByAuthor(Pageable pageable,
                                           @PathVariable Long id) {
        if (isVoteSort(pageable))
            return dtosSortedByVotes(pageable, postRepository
                    .findDistinctByAuthorId(id));
        else
            return dtosFromPage(postRepository
                    .findDistinctByAuthorId(pageable, id));
    }

    private boolean isVoteSort(Pageable pageable) {
        return (pageable != null && pageable.getSort() != null
                && pageable.getSort().toString().toLowerCase()
                .contains("votes"));
    }

    private List<PostSimpleDTO> dtosSortedByVotes(Pageable pageable,
                                            Iterable<Post> toBeSorted) {
        List<PostSimpleDTO> dtos = new ArrayList<>();
        for (Post p : toBeSorted) {
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

    private List<PostSimpleDTO> dtosFromPage(Page<Post> page) {
        if (page == null)
            return null;
        List<PostSimpleDTO> posts = new ArrayList<>();
        for (Post p : page.getContent()) {
            posts.add(PostSimpleDTO.fromPost(p));
        }
        return posts;
    }
}
