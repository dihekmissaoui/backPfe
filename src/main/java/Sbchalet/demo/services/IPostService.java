package Sbchalet.demo.services;
import java.util.List;
import java.util.Optional;

import Sbchalet.demo.models.Post;
public interface IPostService {
	List<Post> list();

	Post save(Post p);

	void remove(int id);

	Post updatePost(int idPost, Post post);

	Optional<Post> getById(int idPost);
      
	void likePost (int id);
	
	void dislikePost (int id);
	
	List<Post> getPostByHighLike();
	
	List<Post> getPostByTitle(String title);
	
	List<Post> getPostWithMaxComments ();

	
}
