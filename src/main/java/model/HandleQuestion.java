package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class HandleQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qId;
	@Lob
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String ans;
	public int getQId() {
		return qId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptionA(){
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public HandleQuestion(String question, String optionA, String optionB, String optionC, String optionD, String ans) {
		super();
		this.question = question;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.ans = ans;
	}
	public HandleQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "HandleQuestion [question=" + question + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC="
				+ optionC + ", optionD=" + optionD + ", ans=" + ans + "]";
	}
}
