package Sbchalet.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.services.ICommentPost;

@RestController
@RequestMapping("/api/commentpost")
public class CommentPostController {
	@Autowired
	ICommentPost commentPostService;

	@GetMapping("/")
	public List<CommentPost> getAllCommentPost() {
		return this.commentPostService.list();
	}

	@GetMapping("/{comment-id}")
	@ResponseBody
	public Optional<CommentPost> retrieveCommentPost(@PathVariable("comment-id") int id) {
		return this.commentPostService.getById(id);
	}

	@PostMapping("/")
	@ResponseBody
	public CommentPost addCommentPost(@RequestBody CommentPost CommentPost) {
		CommentPost comment = commentPostService.save(CommentPost);
		return comment;
	}

	@DeleteMapping("/{id}")
	@ResponseBody
	public void removeCommentPost(@PathVariable("id") int id) {
		commentPostService.remove(id);
	}

	@PutMapping("/{id}")
	@ResponseBody
	public CommentPost modifyCommentPost(@PathVariable int id, @RequestBody CommentPost CommentPost) {
		return commentPostService.updatecommnentPost(id, CommentPost);
	}

	@PutMapping("/like/{id}")
	@ResponseBody
	public void likeCommentPost(@PathVariable int id) {
		System.out.println("je suis ici dans like");
		commentPostService.likeCommentPost(id);

	}

	@PutMapping("/dislike/{id}")
	public void dislike(@PathVariable int id) {
		System.out.println("je suis ici dans dislike");
		commentPostService.dislikeCommentPost(id);

	}

}
