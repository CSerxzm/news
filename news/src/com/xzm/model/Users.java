package com.xzm.model;

public class Users {
	private String userName;
	private String userPass;
	private String isRoot;

	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	@Override
	public String toString() {
		return "User \n[userName=" + userName + ", userPass=" + userPass
				+ ",isRoot="+isRoot+"]";
	}

}
