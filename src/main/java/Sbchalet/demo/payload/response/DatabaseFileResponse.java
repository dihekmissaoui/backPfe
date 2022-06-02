package Sbchalet.demo.payload.response;

public class DatabaseFileResponse {
	private String id;
	private String fileName;
	private String fileType;
	private long size;
	private byte[] data;

	public DatabaseFileResponse() {
		super();

	}

	public DatabaseFileResponse(String id, String fileName, String fileDownloadUri, String fileType, long size) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.size = size;
	} 
	

	public DatabaseFileResponse(String id, String fileName, String fileType, long size,
			byte[] data) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.fileType = fileType;
		this.size = size;
		this.data = data;
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

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
