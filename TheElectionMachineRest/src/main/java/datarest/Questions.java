package datarest;

import java.io.Serializable;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import data.Answers;

/**
 * Class for making objects from Questions
 * 
 *Date: May 4-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */
@Entity
@XmlRootElement
@Table(name = "questions")

public class Questions implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * int value for question_id
	 */
	@Id
	@Column(name = "question_id")
	private int question_id;
	/**
	 * String value for question
	 */
	@Column(name = "question")
	private String question;

	/**
	 *Default constructor for Questions
	 */
	public Questions() {
	}

	/**
	 *Constructor for Questions without question_id
	 * @param question_id
	 */
	public Questions(String question) {
		this.question = question;
	}

	/**
	 * Constructor for Questions
	 * @param quesid
	 * @param question
	 */
	public Questions(int quesid, String question) {

		this.question_id = quesid;
		this.question = question;
	}

	/**
	 * Method for getting question_id
	 * @return question_id
	 */
	public int getQuestion_id() {
		return question_id;
	}

	/**
	 * Method for setting question_id
	 * @param question_id
	 */
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}

	/**
	 * Method for getting question
	 * @return question
	 */
	public String getQuestion() {
		return question;
	}

	/**
	 * Method for setting question
	 * @param question
	 */
	public void setQuestion(String question) {
		this.question = question;
	}

}
