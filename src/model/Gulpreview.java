package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GULPREVIEW database table.
 * 
 */
@Entity
@NamedQuery(name="Gulpreview.findAll", query="SELECT g FROM Gulpreview g")
public class Gulpreview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GULPREVIEW_REVIEWID_GENERATOR", sequenceName="GULPREVIEW_SEQ",  allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GULPREVIEW_REVIEWID_GENERATOR")
	private long reviewid;

	@Temporal(TemporalType.DATE)
	private Date reviewdate;

	private BigDecimal reviewrating;

	private String reviewtext;

	//bi-directional many-to-one association to Gulprestaurant
	@ManyToOne
	@JoinColumn(name="RESTAURANTID")
	private Gulprestaurant gulprestaurant;

	//bi-directional many-to-one association to Gulpuser
	@ManyToOne
	@JoinColumn(name="USERID")
	private Gulpuser gulpuser;

	public Gulpreview() {
	}

	public long getReviewid() {
		return this.reviewid;
	}

	public void setReviewid(long reviewid) {
		this.reviewid = reviewid;
	}

	public Date getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public BigDecimal getReviewrating() {
		return this.reviewrating;
	}

	public void setReviewrating(BigDecimal reviewrating) {
		this.reviewrating = reviewrating;
	}

	public String getReviewtext() {
		return this.reviewtext;
	}

	public void setReviewtext(String reviewtext) {
		this.reviewtext = reviewtext;
	}

	public Gulprestaurant getGulprestaurant() {
		return this.gulprestaurant;
	}

	public void setGulprestaurant(Gulprestaurant gulprestaurant) {
		this.gulprestaurant = gulprestaurant;
	}

	public Gulpuser getGulpuser() {
		return this.gulpuser;
	}

	public void setGulpuser(Gulpuser gulpuser) {
		this.gulpuser = gulpuser;
	}

}