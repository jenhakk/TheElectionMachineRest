package datarest;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity    
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
	
	

