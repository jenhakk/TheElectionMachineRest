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

/**
 * Class for making objects from Answers
 * 
 *Date: May 4-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */
@Entity   
@Table(name = "answers")
public class Answers implements Serializable {
	private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    /**
     * int value of id
     */
    @Column(name = "id")
    private int id;
    /**
     * int value of candidate id
     */
    @Column(name = "candidate_id")
	private int candidate_id;
    /**
     * int value of question id
     */
    @Column(name = "question_id")
	private int question_id;
    /**
     * int value of answer
     */
    @Column(name = "answer")
	private int answer;
    /**
     * String value of comment
     */
    @Column(name = "comment")
    private String comment;
		
	/**
	 * Default constructor for Answers
	 */
	public Answers() {
		
	}
	
	/**
	 * Constructor for Answers
	 * @param candidate_id
	 * @param question_id
	 * @param answer
	 * @param comment
	 */
	public Answers(int candidate_id, int question_id, int answer, String comment) {
		this.candidate_id=candidate_id;
		this.question_id=question_id;
		this.answer=answer;
		this.comment = comment;
	}

	/**
	 * Constructor for Answers without comment
	 * @param candidate_id
	 * @param question_id
	 * @param answer
	 */
	public Answers(int candidate_id, int question_id, int answer) {
		this.candidate_id=candidate_id;
		this.question_id=question_id;
		this.answer=answer;
	}

	/**
	 * Method for getting comment
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * Method for setting comment
	 * @param comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * Method getting id
	 * @return int id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Method for setting id
	 * @param id 
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Method getting candidate id
	 * @return candidate_id
	 */
	public int getCandidate_id() {
		return candidate_id;
	}

	/**
	 * Method setting candidate_id
	 * @param candidate_id
	 */
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}

	/**
	 * Method getting question_id
	 * @return question_id
	 */
	public int getQuestion_id() {
		return question_id;
	}

	/**
	 * Method setting question_id
	 * @param question_id
	 */
	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	/**
	 * Method getting answer
	 * @return answer int
	 */
	public int getAnswer() {
		return answer;
	}

	/**
	 * Method setting answer
	 * @param answer
	 */
	public void setAnswer(int answer) {
		this.answer = answer;
	}

}
