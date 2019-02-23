package cl.mariogonzalez.desafioacidlabs.model.response;

import java.util.List;

public class Items {
	private List<Item> news;
	private List<Item> used;
	
	public Items() {
	}

	public List<Item> getNew() {
		return news;
	}

	public void setNew(List<Item> news) {
		this.news = news;
	}

	public List<Item> getUsed() {
		return used;
	}

	public void setUsed(List<Item> used) {
		this.used = used;
	}
	
	
}
