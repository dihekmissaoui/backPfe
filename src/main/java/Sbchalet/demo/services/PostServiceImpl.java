package Sbchalet.demo.services;

import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Sbchalet.demo.models.Post;
import Sbchalet.demo.repository.PostRepository;

@Service
public class PostServiceImpl implements IPostService {
	@Autowired
	PostRepository postrepository;
	private static final Logger logger = Logger.getLogger(PostServiceImpl.class);

	@Override
	public List<Post> list() {
		try {

			logger.info("Je suis dans ListPost()");
			logger.debug("Je vais retourner ListPost");
			logger.info("Je vien de finir l'operation ");
			return (List<Post>) this.postrepository.findAll();
		} catch (Exception e) {
			logger.error("Error in ListPost() :", e);
		}
		return new ArrayList<>();

	}

	@Override
	public Post save(Post p) {

		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister Post");
			return this.postrepository.save(p);
		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		return new Post();
	}

	@Override
	public void remove(int id) {
		try {
			logger.info("supprimer Post= " + id);
			this.postrepository.deleteById(id);

		} catch (Exception e) {
			logger.error("Error dans save() :", e);
		}
		logger.info("Post supprimer avec succés");

	}

	@Override
	public Post updatePost(int id, Post p) {
		try {
			logger.info("je suis dans updatePost()");
			Post updatedpost = null;
			Optional<Post> searchPost = this.postrepository.findById(id);
			if (searchPost.isPresent()) {
				Post finded = searchPost.get();
				finded = p;
				logger.debug("je vais lancer les modifications ,");
				updatedpost = this.postrepository.save(finded);
			}
			logger.info("j'ai terminé mon instruction ");
			return updatedpost;

		} catch (Exception e) {
			logger.error("Error dans updateChalet :", e);
		}
		return new Post();

	}

	@Override
	public Optional<Post> getById(int id) {

		try {
			logger.info("je suis dans getById");
			logger.info("Je vien de finir l'operation ");
			return this.postrepository.findById(id);

		} catch (Exception e) {
			logger.error("Error dans updateChalet :", e);
		}
		return null;
	}

	@Override
	public void likePost(int id) {
		try {
			logger.info("je suis dans likePost");
			postrepository.likePost(id);
			logger.info("j'ai termnier linstruction()");
		} catch (Exception e) {
			logger.error("Error dans likePost");
		}
	}

	@Override
	public void dislikePost(int id) {
		try {
			logger.info("je suis dans dislikePost()");
			postrepository.dislikePost(id);
			logger.info("j'ai termnier linstruction()");
		} catch (Exception e) {
			logger.error("Error dans DislikePost");
		}
	}

	@Override
	public List<Post> getPostByHighLike() {
		try {
			logger.info("Je suis dans getPostByHighLike");
			return this.postrepository.getPostByHighLike();
		} catch (Exception e) {
			logger.error("Error dans DislikePost");

		}
		return new ArrayList<Post>();
	}

	@Override
	public List<Post> getPostByTitle(String title) {
		try {
			logger.info("Je suis dans getPostByTitle");
			return this.postrepository.getPostByTitle(title);

		} catch (Exception e) {
			logger.error("Error dans DislikePost");
		}
		return new ArrayList<Post>();
	}

	@Override
	public List<Post> getPostWithMaxComments() {
		try {
			logger.info("Je suis dans getPostWithMaxComments");
			return this.postrepository.getPostWithMaxComments();

		} catch (Exception e) {
			logger.error("Error dans getPostWithMaxComments");
		}
		return new ArrayList<Post>();

	}
}
