package data;

public class Candidate {
	private int id;
	private String name;
	private String fname;
	private String promo;
	private String pic;
	private String party;
	private String age;
	private String profession;
	private String municipality;
	private String points;
	
	

	

	public Candidate(String id, String name, String fname, String pic, String promo, String party, String age, String profession, String municipality, String points) {
		// TODO Auto-generated constructor stub
		setId(id);
		this.name=name;
		this.fname=fname;
		this.pic=pic;
		this.promo=promo;
		this.age=age;
		this.party=party;
		this.profession=profession;
		this.municipality=municipality;
		this.points = points;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public Candidate() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setId(String id) {
		try {
			this.id = Integer.parseInt(id);
		}
		catch(NumberFormatException | NullPointerException e) {
			//Do nothing - the value of id won't be changed
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
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

}