package se.qbranch.friendsincommon;

import java.io.Serializable;

class TwitterUser implements Serializable {

	private static final long serialVersionUID = 20100304L;

	private String name;
	private String screenName;
	private String profileImageUrl;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	@Override
	public boolean equals(Object o) {
		return ((TwitterUser) o).screenName.equals(screenName);
	}

	@Override
	public String toString() {
		return "TwitterUser [name=" + name + ", profileImageUrl="
				+ profileImageUrl + ", screenName=" + screenName + "]";
	}
	
}