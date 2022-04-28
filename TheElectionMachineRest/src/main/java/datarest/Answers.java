package datarest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity   
@Table(name = "answers")
public class Answers implements Serializable {
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name = "id")
    private int id;
    @Column(name = "candidate_id")
	private int candidate_id;
    @Column(name = "question_id")
	private int question_id;
    @Column(name = "answer")
	private int answer;
	
//	Let's keep these here for a bit. I think they're unnecessary but if anything goes wrong and these may be related, I'll get them easily back for testing. -Ama	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@PrimaryKeyJoinColumn(name = "question_id")
//	private Questions questions;
	
	public Answers() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCandidate_id() {
		return candidate_id;
	}

	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getAnswer() {
		return answer;
	}

	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
