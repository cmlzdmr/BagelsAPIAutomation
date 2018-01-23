package api.bagels.cmb.beans;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Location {

	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("coordinates")
	@Expose
	private List<Double> coordinates = null;

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Location() {
	}

	/**
	 * 
	 * @param name
	 * @param coordinates
	 */
	public Location(String name, List<Double> coordinates) {
		super();
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

}