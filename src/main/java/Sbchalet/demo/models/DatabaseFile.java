package Sbchalet.demo.models;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class DatabaseFile {
	
	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;

	private String fileName;

	private String fileType;
	@Lob
	private byte[] data;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Chalet chalet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Reservation reservation;


	public DatabaseFile() {
		super();

	}

	public DatabaseFile( String fileName, String fileType, byte[] data) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}
	
	public DatabaseFile(String fileName, String fileType, byte[] data, Chalet chalet) {
			super();
			this.fileName = fileName;
			this.fileType = fileType;
			this.data = data;
			this.chalet = chalet;
		}
	public DatabaseFile(String fileName, String fileType, byte[] data, Reservation reservation) {
		super();
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
		this.reservation = reservation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Chalet getChalet() {
		return chalet;
	}

	public void setChalet(Chalet chalet) {
		this.chalet = chalet;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	@Override
	public String toString() {
		return "DatabaseFile [id=" + id + ", fileName=" + fileName + ", fileType=" + fileType + ", data="
				+ Arrays.toString(data) + ", chalet=" + chalet + ", reservation=" + reservation + "]";
	}
	
	

}
