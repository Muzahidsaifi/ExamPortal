package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GetTimeDuration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int srn;
	private String h;
	private String m;
	private String s;
	
	public String getH() {
		return h;
	}
	public void setH(String h) {
		this.h = h;
	}
	public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	@Override
	public String toString() {
		return "GetTimeDuration [h=" + h + ", m=" + m + ", s=" + s + "]";
	}
	
	
	

}
