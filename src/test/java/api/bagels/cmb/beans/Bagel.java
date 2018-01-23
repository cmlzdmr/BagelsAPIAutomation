package api.bagels.cmb.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bagel {

	@SerializedName("id")
	@Expose
	private Integer id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("age")
	@Expose
	private Integer age;
	@SerializedName("gender")
	@Expose
	private String gender;
	@SerializedName("locations")
	@Expose
	private List<Location> locations = null;

	public Bagel() {
	}

	/**
	 * 
	 * @param id
	 * @param locations
	 * @param age
	 * @param name
	 * @param gender
	 */
	public Bagel(Integer id, String name, Integer age, String gender, List<Location> locations) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.locations = locations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Location> getLocations() {
		return locations;
	}

	public void setLocations(List<Location> locations) {
		this.locations = locations;
	}

}
