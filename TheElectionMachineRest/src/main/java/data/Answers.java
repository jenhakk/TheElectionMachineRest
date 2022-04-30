package data;

import java.util.ArrayList;
import java.util.List;

public class Answers {
	private int quess_id;
	private int candi_id;
	private int answer;
	private String question;
	private String lastname;
	private String firstname;
	private String promo;
	private String pic;
	private String party;
	private String age;
	private String profession;
	private String municipality;
	private String comment;
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

	private ArrayList<Answers> answers;
	
	
	public Answers (int candi_id, int answer) {
		
		this.candi_id = candi_id;
		this.answer = answer;
	}
	
	public ArrayList<Answers> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answers> answers) {
		this.answers = answers;
	}

	public Answers (int candi_id, int quess_id, int answer) {
		
		this.candi_id = candi_id;
		this.quess_id = quess_id;
		this.answer = answer; 
	}
	


	public Answers (String candi_id, String quess_id, String answer) {
		setCandi_id(candi_id);
		setQuess_id(quess_id);
		setAnswer(answer);
		}


	public Answers(int idst, String name, String fname, String promo, String pic, String age, String municipality,
			String party, String profession) {
		this.candi_id=idst;
		this.lastname=name;
		this.firstname=fname;
		this.promo=promo;
		this.pic=pic;
		this.party=party;
		this.age=age;
		this.profession=profession;
		this.municipality=municipality;
	}
	public Answers() {
		// TODO Auto-generated constructor stub
	}
	public Answers(int candi_id, int quess_id, int answer, String comment) {
		this.candi_id = candi_id;
		this.quess_id = quess_id;
		this.answer = answer;
		this.comment = comment;
	}

	public String getPromo() {
		return promo;
	}
	public void setPromo(String promo) {
		this.promo = promo;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getMunicipality() {
		return municipality;
	}
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public int getQuess_id() {
		return quess_id;
	}
	public void setQuess_id(int quess_id) {
		this.quess_id = quess_id;
	}
	public int getCandi_id() {
		return candi_id;
	}
	public void setCandi_id(int candi_id) {
		this.candi_id = candi_id;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	
	public void setCandi_id(String candi_id) {
		try {
			this.candi_id = Integer.parseInt(candi_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public void setAnswer(String answer) {
		try {
			this.answer = Integer.parseInt(answer);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public void setQuess_id(String quess_id) {
		try {
			this.quess_id = Integer.parseInt(quess_id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}

		
}
