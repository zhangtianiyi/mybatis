package entity;

public class Customer {
	private String cname;
	private String cpass;
	private String cphone;
	private String caddress;
	private String crealname;
	private boolean cislogin;
	public Customer(){
		super();
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}
	public String getCphone() {
		return cphone;
	}
	public void setCphone(String cphone) {
		this.cphone = cphone;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getCrealname() {
		return crealname;
	}
	public void setCrealname(String crealname) {
		this.crealname = crealname;
	}
	public boolean isCislogin() {
		return cislogin;
	}
	public void setCislogin(boolean cislogin) {
		this.cislogin = cislogin;
	}
	
}
