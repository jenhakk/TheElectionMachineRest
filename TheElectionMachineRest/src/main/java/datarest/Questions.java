package datarest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
@Table(name= "questions")
@NamedQueries({
@NamedQuery(name="Questions.findAll", query="select q from Questions q"),
@NamedQuery(name = "Questions.findByQuestion_id", query = "SELECT q FROM Questions q WHERE q.question_id = :question_id and q.question= :question")
//@NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question")
})
public class Questions implements Serializable{

	    private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name = "question_id")
	    private int question_id;
	    @Column (name= "question")
	    private String question;	    
	   
	    /**
	     *
	     */
	    public Questions() {
	    }

	    /**
	     *
	     * @param question_id
	     */
	    public Questions(String question) {
	        this.question = question;
	    }

	    public Questions(int quesid, String question) {
			
	    	this.question_id = quesid;
	    	this.question = question;
		}



		/**
	     *
	     * @return
	     */
	    public int getQuestion_id() {
	        return question_id;
	    }

	    /**
	     *
	     * @param question_id
	     */
	    public void setQuestion_id(Integer question_id) {
	        this.question_id = question_id;
	    }

	    /**
	     *
	     * @return
	     */
	    public String getQuestion() {
	        return question;
	    }

	    /**
	     *
	     * @param question
	     */
	    public void setQuestion(String question) {
	        this.question = question;
	    }

	}
	
	

