package datarest;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Class for making objects from Admin
 * 
 *Date: May 4-2022
 * @author jenna hakkarainen, amanda karjalainen, anna-maria palm
 *
 */

@Entity
@XmlRootElement
@Table(name = "admin")
@NamedQuery(name="Admin.findAll", query="select a from Admin a")
public class Admin implements Serializable{
	
	private static final long serialVersionUID = 1L;
	/**
	 * int value for id
	 */
	@Id
	private int id;
	/**
	 * String value for username
	 */
	private String username;
	/**
	 * String password
	 */
	private String password;
	/**
	 * Constructor for Admin
	 * @param id
	 * @param username
	 * @param password
	 */
	public Admin(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}
	/**
	 * Default constructor for Admin
	 */
	public Admin() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Constructor for Admin without id
	 * @param user String value of username
	 * @param pass String value of password
	 */
	public Admin(String user, String pass) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Method for gettin id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Method for setting id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Method for getting username
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * Method for setting username
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * Method for getting password
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Method for setting password
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
}
