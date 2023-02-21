package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AdminModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srn;
	private String adminid;
	private String pass;
	
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public AdminModel(String adminid, String pass) {
		super();
		this.adminid = adminid;
		this.pass = pass;
	}
	public AdminModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AdminModel [adminid=" + adminid + ", pass=" + pass + "]";
	}
	
	

}
