package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MyModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qid;
	private String myname;
	private String myquestion;
	private String myans;
	public String getMyname() {
		return myname;
	}
	public void setMyname(String myname) {
		this.myname = myname;
	}
	public String getMyquestion() {
		return myquestion;
	}
	public void setMyquestion(String myquestion) {
		this.myquestion = myquestion;
	}
	public String getMyans() {
		return myans;
	}
	public void setMyans(String myans) {
		this.myans = myans;
	}
	public MyModel(String myname, String myquestion, String myans) {
		super();
		this.myname = myname;
		this.myquestion = myquestion;
		this.myans = myans;
	}
	public MyModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyModel [myname=" + myname + ", myquestion=" + myquestion + ", myans=" + myans + "]";
	}
	

}
