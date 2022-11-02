package com.example.demo;

import java.util.ArrayList;

public class Response {
	private String transactionId;
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private double totalCost = 0;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void calculateTotalCost() {
		double temp = 0;
		for (int i = 0; i < tickets.size(); i++) {
			if (tickets.get(i).getTicketType() == TicketType.Children && tickets.get(i).getQuantity() >= 3) {
				temp += tickets.get(i).getTotalCost() * 0.75;
			} else {
				temp += tickets.get(i).getTotalCost();
			}
		}
		this.setTotalCost(temp);
	}

	private ArrayList<TicketType> getTicketTypes() {
		ArrayList<TicketType> ticketTypes = new ArrayList<TicketType>();
		for (Ticket ticket : tickets) {
			ticketTypes.add(ticket.getTicketType());
		}
		return ticketTypes;
	}

	public void addTicket(Ticket ticket) {
		ArrayList<TicketType> ticketTypes = this.getTicketTypes();
		if (ticketTypes.contains(ticket.getTicketType())) {
			for (Ticket existingTicket : tickets) {
				if (existingTicket.getTicketType() == ticket.getTicketType()) {
					existingTicket.setQuantity(existingTicket.getQuantity() + 1);
					existingTicket.setTotalCost(existingTicket.getTotalCost() + ticket.getTotalCost());
					this.calculateTotalCost();
					return;
				}
			}
		} else {
			this.tickets.add(ticket);
			this.calculateTotalCost();
		}
	}
}
