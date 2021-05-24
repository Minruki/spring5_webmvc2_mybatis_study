package spring5_webmvc2_mybatis_study.dto;

import javax.validation.constraints.NotEmpty;

public class ChangePwdCommand {
	
	@NotEmpty
	private String currentPassword;
	@NotEmpty
	private String newPassword;

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}