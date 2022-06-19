package Sbchalet.demo.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	private String username;

	@NotBlank
	private String password;
	
	@NotBlank 
	String email;
	
	

	public LoginRequest(@NotBlank String email, @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
