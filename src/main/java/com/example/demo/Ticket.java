package com.example.demo;

enum TicketType {
	Adult, Senior, Teen, Children
}

public class Ticket {
	private TicketType ticketType;
	private int quantity;
	private double totalCost;
	public TicketType getTicketType() {
		return ticketType;
	}
	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void addOne(double addCost) {
		this.setQuantity(this.quantity + 1);
		this.setTotalCost(this.totalCost + addCost);
	}
}
