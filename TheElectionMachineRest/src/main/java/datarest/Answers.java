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
    @Column(name = "comment")
    private String comment;
		
	public Answers() {
		
	}
	
	public Answers(int candidate_id, int question_id, int answer, String comment) {
		this.candidate_id=candidate_id;
		this.question_id=question_id;
		this.answer=answer;
		this.comment = comment;
	}

	public Answers(int candidate_id, int question_id, int answer) {
		this.candidate_id=candidate_id;
		this.question_id=question_id;
		this.answer=answer;
	}

	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
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
