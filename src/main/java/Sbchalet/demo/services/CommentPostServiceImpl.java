package Sbchalet.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Sbchalet.demo.models.CommentPost;
import Sbchalet.demo.repository.CommentPostRepository;

@Service
public class CommentPostServiceImpl implements ICommentPost {

	@Autowired
	CommentPostRepository commentpostrepository;
	private static final Logger logger = Logger.getLogger(CommentPostServiceImpl.class);

	@Override
	public List<CommentPost> list() {
		try {
			logger.info(" Je suis dans Listcomment ");
			logger.debug("Je vais retourner Listchalet");
			return (List<CommentPost>) this.commentpostrepository.findAll();

		} catch (Exception e) {
			logger.error("Error in ListChalet() :", e);
		}
		return new ArrayList<CommentPost>();
	}

	@Override
	public CommentPost save(CommentPost c) {
		try {
			logger.trace("accès à la méthode");
			logger.info("je vais enregister CommentPost");
			return this.commentpostrepository.save(c);

		} catch (Exception e) {
			logger.error("Error in saveCommentPost() :", e);
		}
		return new CommentPost();

	}

	@Override
	public void remove(int idpostcomment) {
		try {
			logger.info("supprimer comment= " + idpostcomment);
			this.commentpostrepository.deleteById(idpostcomment);

		} catch (Exception e) {
			logger.error("Error avec  suppresion Comment :", e);

		}
		logger.info("comment n'existe pas");

	}

	@Override
	public Optional<CommentPost> getById(int idpostcomment) {
		try {
			logger.info("je vais afficher le Chalet par id =" + idpostcomment);
			return this.commentpostrepository.findById(idpostcomment);
		} catch (Exception e) {
			logger.error("Error avec  suppresion Comment :", e);
		}
		return null;

	}

	@Override
	public CommentPost updatecommnentPost(int idpostcomment, CommentPost comment) {
		try {
			logger.info("je suis dans updatecommnentPost()");
			CommentPost updatecommnentPost = null;
			Optional<CommentPost> commantaire = this.commentpostrepository.findById(idpostcomment);
			if (commantaire.isPresent()) {
				CommentPost upcommant = commantaire.get();
				upcommant = comment;
				logger.debug("je vais lancer commnentPost ,");
				updatecommnentPost = this.commentpostrepository.save(upcommant);
			}
			logger.info("j'ai terminé mon instruction avec succes ");
			return updatecommnentPost;

		} catch (Exception e) {
			logger.error("Error dans updatecommnentPost :", e);
		}

		return new CommentPost();
	}

	@Override
	public void likeCommentPost(int id) {
		try {
			logger.info("je suis dans likePost");
			commentpostrepository.likeCommentPost(id);

		} catch (Exception e) {
			logger.error("Error dans likeCommentPost :", e);
		}
		logger.info("j'ai terminer l'instruction");
	}

	@Override
	public void dislikeCommentPost(int id) {
		try {
			logger.info("je suis dans dislikeCommentPost");
			commentpostrepository.dislikeCommentPost(id);

		} catch (Exception e) {
			logger.error("Error dans dislikeCommentPost :", e);
		}
		logger.info("j'ai terminer l'instruction");
	}

}
