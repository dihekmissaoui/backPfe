
package Sbchalet.demo.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // pour afficher le post du
																							// comment
public class Post {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;// clé primaire
	private String title;
	@Temporal(TemporalType.DATE) // pour avoir le type de date
	private Date date;
	private String content;
	private int likes;
	private int dislikes;

	// chaque poste a plusieur comment
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE }, mappedBy = "post", orphanRemoval = true)
	private Set<CommentPost> comments;
	// @JsonManagedReference

	// chaque post a plusieur images
	// @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.MERGE }, mappedBy
	// = "post")
	// private List<DatabaseFile> databaseFile = null;

	@ManyToOne
	private User user;

	public Post() {
		super();
	}

	public Post(int id, String title, Date date, String content, int likes, int dislikes, Set<CommentPost> comments,
			User user) {
		super();
		this.id = id;
		this.title = title;
		this.date = date;
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
		this.comments = comments;
		this.user = user;
	}

	public Post(String title, Date date, String content, int likes, int dislikes, Set<CommentPost> comments,
			User user) {
		super();
		this.title = title;
		this.date = date;
		this.content = content;
		this.likes = likes;
		this.dislikes = dislikes;
		this.comments = comments;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<CommentPost> getComments() {
		return comments;
	}

	public void setComments(Set<CommentPost> comments) {
		this.comments = comments;
	}

	public void addComment(CommentPost comment) {
		this.comments.add(comment);
		comment.setPost(this);
	}

	public void removeComment(CommentPost comment) {
		comment.setPost(null);
		this.comments.remove(comment);
	}

//	public List<DatabaseFile> getDatabaseFile() {
//		return databaseFile;
	// }

	// public void setDatabaseFile(List<DatabaseFile> databaseFile) {
	// if (this.databaseFile == null) {
	// this.databaseFile = databaseFile;
	// } else {
	// this.databaseFile.retainAll(databaseFile);
	// this.databaseFile.addAll(databaseFile);
	// }

	// this.databaseFile = databaseFile;
	// }

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		// result = prime * result + ((databaseFile == null) ? 0 :
		// databaseFile.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + dislikes;
		result = prime * result + id;
		result = prime * result + likes;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;

		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
