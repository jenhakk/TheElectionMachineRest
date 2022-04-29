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
 * @author jenna
 *
 */

@Entity
@XmlRootElement
@Table(name= "candidates")
@NamedQuery(name="Candidates.findAll", query="select c from Candidates c")
public class Candidates implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "candidate_id")
    private int candidate_id;
    @Column (name= "lastname")
    private String lname;
    @Column(name = "firstname")
    private String fname;
    @Column (name= "picture")
    private String pic;
    @Column (name= "party")
    private String party;
    @Column(name = "municipality")
    private String munic;
    @Column (name= "age")
    private String age;
    @Column (name= "what_to_promote")
    private String promo;
    @Column(name = "profession")
    private String prof;
    
    public Candidates() {
    	
    }
    
    
	/**
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
	 * @return the canididate_id
	 */
	public int getCandidate_id() {
		return candidate_id;
	}
	/**
	 * @param canididate_id the canididate_id to set
	 */
	public void setCandidate_id(int candidate_id) {
		this.candidate_id = candidate_id;
	}
	
	/**
	 * @param canididate_id the canididate_id to set
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
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}
	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}
	/**
	 * @return the party
	 */
	public String getParty() {
		return party;
	}
	/**
	 * @param party the party to set
	 */
	public void setParty(String party) {
		this.party = party;
	}
	/**
	 * @return the munic
	 */
	public String getMunic() {
		return munic;
	}
	/**
	 * @param munic the munic to set
	 */
	public void setMunic(String munic) {
		this.munic = munic;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the promo
	 */
	public String getPromo() {
		return promo;
	}
	/**
	 * @param promo the promo to set
	 */
	public void setPromo(String promo) {
		this.promo = promo;
	}
	/**
	 * @return the prof
	 */
	public String getProf() {
		return prof;
	}
	/**
	 * @param prof the prof to set
	 */
	public void setProf(String prof) {
		this.prof = prof;
	}

    

}
