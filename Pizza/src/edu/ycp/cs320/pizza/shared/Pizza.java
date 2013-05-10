package edu.ycp.cs320.pizza.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class Pizza extends Publisher implements Serializable {
	public enum Events {
		SIZE_CHANGED,
		ADD_TOPPING,
		REMOVE_TOPPING,
	}
	
	private Size size;
	private ArrayList<Topping> toppingList;
	
	public Pizza() {
		this.size = Size.MEDIUM;
		this.toppingList = new ArrayList<Topping>();
	}
	
	public void setSize(Size size) {
		this.size = size;
		notifySubscribers(Events.SIZE_CHANGED, size);
	}
	
	public Size getSize() {
		return size;
	}
	
	public void addTopping(Topping topping) {
		if (!toppingList.contains(topping)) {
			toppingList.add(topping);
			notifySubscribers(Events.ADD_TOPPING, topping);
		}
	}
	
	public void removeTopping(Topping topping) {
		if (toppingList.remove(topping)) {
			notifySubscribers(Events.REMOVE_TOPPING, topping);
		}
	}
	
	public List<Topping> getToppingList() {
		return toppingList;
	}
}
