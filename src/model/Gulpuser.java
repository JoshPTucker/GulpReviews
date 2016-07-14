package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GULPUSER database table.
 * 
 */
@Entity
@NamedQuery(name="Gulpuser.findAll", query="SELECT g FROM Gulpuser g")
public class Gulpuser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GULPUSER_USERID_GENERATOR", sequenceName="GULPUSER_SEQ",  allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GULPUSER_USERID_GENERATOR")
	private long userid;

	private String firstname;

	private String lastname;

	private String useremail;

	private String userpassword;

	private BigDecimal zipcode;

	//bi-directional many-to-one association to Gulpreview
	@OneToMany(mappedBy="gulpuser")
	private List<Gulpreview> gulpreviews;

	public Gulpuser() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUseremail() {
		return this.useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getUserpassword() {
		return this.userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public BigDecimal getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(BigDecimal zipcode) {
		this.zipcode = zipcode;
	}

	public List<Gulpreview> getGulpreviews() {
		return this.gulpreviews;
	}

	public void setGulpreviews(List<Gulpreview> gulpreviews) {
		this.gulpreviews = gulpreviews;
	}

	public Gulpreview addGulpreview(Gulpreview gulpreview) {
		getGulpreviews().add(gulpreview);
		gulpreview.setGulpuser(this);

		return gulpreview;
	}

	public Gulpreview removeGulpreview(Gulpreview gulpreview) {
		getGulpreviews().remove(gulpreview);
		gulpreview.setGulpuser(null);

		return gulpreview;
	}

}