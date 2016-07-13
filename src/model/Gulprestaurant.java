package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GULPRESTAURANT database table.
 * 
 */
@Entity
@NamedQuery(name="Gulprestaurant.findAll", query="SELECT g FROM Gulprestaurant g")
public class Gulprestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GULPRESTAURANT_RESTAURANTID_GENERATOR", sequenceName="GULPRESTAURANT_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GULPRESTAURANT_RESTAURANTID_GENERATOR")
	private long restaurantid;

	private BigDecimal averagerating;

	private String restaurantaddress;

	private String restaurantdescription;

	private String restaurantname;

	private BigDecimal restaurantzipcode;

	//bi-directional many-to-one association to Gulpreview
	@OneToMany(mappedBy="gulprestaurant")
	private List<Gulpreview> gulpreviews;

	public Gulprestaurant() {
	}

	public long getRestaurantid() {
		return this.restaurantid;
	}

	public void setRestaurantid(long restaurantid) {
		this.restaurantid = restaurantid;
	}

	public BigDecimal getAveragerating() {
		return this.averagerating;
	}

	public void setAveragerating(BigDecimal averagerating) {
		this.averagerating = averagerating;
	}

	public String getRestaurantaddress() {
		return this.restaurantaddress;
	}

	public void setRestaurantaddress(String restaurantaddress) {
		this.restaurantaddress = restaurantaddress;
	}

	public String getRestaurantdescription() {
		return this.restaurantdescription;
	}

	public void setRestaurantdescription(String restaurantdescription) {
		this.restaurantdescription = restaurantdescription;
	}

	public String getRestaurantname() {
		return this.restaurantname;
	}

	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}

	public BigDecimal getRestaurantzipcode() {
		return this.restaurantzipcode;
	}

	public void setRestaurantzipcode(BigDecimal restaurantzipcode) {
		this.restaurantzipcode = restaurantzipcode;
	}

	public List<Gulpreview> getGulpreviews() {
		return this.gulpreviews;
	}

	public void setGulpreviews(List<Gulpreview> gulpreviews) {
		this.gulpreviews = gulpreviews;
	}

	public Gulpreview addGulpreview(Gulpreview gulpreview) {
		getGulpreviews().add(gulpreview);
		gulpreview.setGulprestaurant(this);

		return gulpreview;
	}

	public Gulpreview removeGulpreview(Gulpreview gulpreview) {
		getGulpreviews().remove(gulpreview);
		gulpreview.setGulprestaurant(null);

		return gulpreview;
	}

}