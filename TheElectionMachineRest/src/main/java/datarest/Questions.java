package datarest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@NamedQuery(name = "Questions.findByQuestion_id", query = "SELECT q FROM Questions q WHERE q.question_id = :question_id"),
@NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question")
})
public class Questions implements Serializable{

	    private static final long serialVersionUID = 1L;
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int question_id;
	    
	    private String question;	    
	   
	    
	    private List<Questions> questionlist;
	    /**
	     *
	     */
	    public Questions() {
	    }
	    
	    
	    
	    public List<Questions> getQuestionlist() {
	    	if (this.questionlist==null) {
	    		questionlist=new ArrayList<>();
	    	}
	    	return this.questionlist;
	    }
	    
	    public void setQuestionlist(List<Questions> questionlist) {
	    	this.questionlist=questionlist;
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
	
	

