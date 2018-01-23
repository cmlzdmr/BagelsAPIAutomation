package api.bagels.cmb.beans;

import java.util.List;

public class Bagels {
	private List<Bagel> bagels;

	public List<Bagel> getBagels() {
		return bagels;
	}

	public void setBagels(List<Bagel> bagels) {
		this.bagels = bagels;
	}

	public Bagels(List<Bagel> bagels) {
		super();
		this.bagels = bagels;
	}

	public Bagels() {
		super();
	}
	
}
