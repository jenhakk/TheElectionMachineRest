/**
 * 
 */
package datarest;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for making objects from Candidates
 * 
 *Date: May 4-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */
@Entity
@XmlRootElement
@Table(name= "candidates")
@NamedQuery(name="Candidates.findAll", query="select c from Candidates c")
public class Candidates implements Serializable {
	
	private static final long serialVersionUID = 1L;
    /**
     * int value candidate_id
     */
    @Id
    @Column(name = "candidate_id")
    private int candidate_id;
    /**
     * String value for lastname
     */
    @Column (name= "lastname")
    private String lname;
    /**
     * String value for firstname
     */
    @Column(name = "firstname")
    private String fname;
    /**
     * String value for picture
     */
    @Column (name= "picture")
    private String pic;
    /**
     * String value for party
     */
    @Column (name= "party")
    private String party;
    /**
     * String value for municipality
     */
    @Column(name = "municipality")
    private String munic;
    /**
     * String value for age
     */
    @Column (name= "age")
    private String age;
    /**
     * String value for what to promote
     */
    @Column (name= "what_to_promote")
    private String promo;
    /**
     * String value for profession
     */
    @Column(name = "profession")
    private String prof;
    
    /**
     * Default constructor for Candidates
     */
    public Candidates() {
    	
    }
    
    
	/**
	 * Constructor for Candidates
	 * @param cand_id
	 * @param lname
	 * @param fname
	 * @param pic
	 * @param party
	 * @param munic
	 * @param age
	 * @param promo
	 * @param prof
	 */
	public Candidates(int candidate_id, String lname, String fname, String pic, String party, String munic, String age,
			String promo, String prof) {
		super();
		this.candidate_id = candidate_id;
		this.lname = lname;
		this.fname = fname;
		this.pic = pic;
		this.party = party;
		this.munic = munic;
		this.age = age;
		this.promo = promo;
		this.prof = prof;
	}
	
	/**
	 * Constructor for Candidates without candidate id
	 * @param lname
	 * @param fname
	 * @param pic
	 * @param party
	 * @param munic
	 * @param age
	 * @param promo
	 * @param prof
	 */
	public Candidates(String lname, String fname, String pic, String party, String munic, String age,
			String promo, String prof) {
		this.lname = lname;
		this.fname = fname;
		this.pic = pic;
		this.party = party;
		this.munic = munic;
		this.age = age;
		this.promo = promo;
		this.prof = prof;
	}


	/**
	 * 
	 * Method for getting candidate_id
	 * @return the candidate_id
	 */
	public int getCandidate_id() {
		return candidate_id;
	}
	/**
	 * Method for setting candidate_id
	 * @param the candidate_id to set
	 */
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	/**
	 * Method for setting candidate_id to String
	 * @param the candidate_id to set
	 */
	public void setId(String id) {
		try {
			this.candidate_id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	
	/**
	 * Method for getting lastname
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * Method for setting lastname
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * Method for getting firstname
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * Method for setting firstname
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * Method for getting picture
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * Method for setting picture
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * Method for getting party
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * Method for setting party
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}
	/**
	 * Method for getting municipality
	 * @return the munic
	 */
	public String getMunic() {
		return munic;
	}
	/**
	 * Method for setting municipality
	 * @param munic the munic to set
	 */
	public void setMunic(String munic) {
		this.munic = munic;
	}
	/**
	 * Method for getting age
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * Method for setting age
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * Method for getting what to promote
	 * @return the promo
	 */
	public String getPromo() {
		return promo;
	}
	/**
	 * Method for setting what to promote
	 * @param promo the promo to set
	 */
	public void setPromo(String promo) {
		this.promo = promo;
	}
	/**
	 * Method for getting profession
	 * @return the prof
	 */
	public String getProf() {
		return prof;
	}
	/**
	 * Method for setting profession
	 * @param prof the prof to set
	 */
	public void setProf(String prof) {
		this.prof = prof;
	}

    

}
