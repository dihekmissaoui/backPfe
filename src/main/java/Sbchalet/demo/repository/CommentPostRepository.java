package Sbchalet.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Sbchalet.demo.models.CommentPost;
@Repository
public interface CommentPostRepository extends CrudRepository<CommentPost, Integer>{

	@Transactional
	@Modifying
	@Query("UPDATE CommentPost p SET p.likes = p.likes+1 WHERE p.id=:id")
	void likeCommentPost(@Param("id")int id );
	
	@Transactional
	@Modifying
	@Query("UPDATE CommentPost p SET p.dislikes = p.likes+1 WHERE p.id=:id")
	void dislikeCommentPost(@Param("id") int id);
}
