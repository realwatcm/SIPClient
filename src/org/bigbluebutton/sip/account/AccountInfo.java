package org.bigbluebutton.sip.account;

public class AccountInfo {
	
	private final String BBB_USERNAME     = "bbbuser" ;
	private final String BBB_PASSWORD     = "secret" ;
	private final String BBB_PROTOCOL     = "sip:" ;
	private final long   BBB_PORT         = 5070 ;
	private final String BBB_REALM        = "*";
	private final String BBB_AUTH         = "Digest" ;
	
	private String bbb_display_name       = null ;
	private String bbb_domain             = null ;
	private String bbb_room               = null ;
	
	
	public String getUserName(){
		return this.BBB_USERNAME ;
	}
	
	public String getPassword(){
		return this.BBB_PASSWORD ;
	}
	
	public String getProtocol(){
		return this.BBB_PROTOCOL ;
	}
	
	public long getPort(){
		return this.BBB_PORT ;
	}
	
	public String getRealm(){
		return this.BBB_REALM ;
	}
	
	public String getAuth(){
		return this.BBB_AUTH ;
	}
	
	public void setDomain(String domain){
		this.bbb_domain = domain ;
	}
	
	public void setRoom(String room){
		this.bbb_room = room ;
	}
	
	public String getRoom(){
		return this.bbb_room ;
	}
	
	public String getDomain(){
		return this.bbb_domain ;
	}
	
	public String getDisplayName(){
		return this.bbb_display_name ;
	}
	
	public void setDisplayName(String name){
		this.bbb_display_name = name ;
	}
	
	public String getSipCallToUrl(){
		return getProtocol() + getRoom() + "@" + getDomain() ;
	}
	
	public String getSipCallFromUrl(){
		return getDisplayName() + " " + getProtocol() + getUserName() + "@" + getDomain() ;
	}
	
	
}
