package model;

import java.util.Random;

public class Question {
	String qid;
	String question;
	String answer;
	String tname;
	public Question(String qid, String question, String answer, String tname) {
		super();
		this.qid = qid;
		this.question = question;
		this.answer = answer;
		this.tname = tname;
	}
	
	public Question() {
		this.qid=String.format("%04d", new Random().nextInt(10000));
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
	
}
