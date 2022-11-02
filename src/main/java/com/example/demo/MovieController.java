package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	@GetMapping("/")
	public String first() {
		return "Hello World";
	}

	private Ticket getTicketForAge(int age) {
		Ticket ticket = new Ticket();
		if (age >= 18 && age < 65) {
			ticket.setTotalCost(25);
			ticket.setTicketType(TicketType.Adult);
			ticket.setQuantity(1);
		} else if (age >= 65) {
			ticket.setTotalCost(25 * 0.7);
			ticket.setTicketType(TicketType.Senior);
			ticket.setQuantity(1);
		} else if (age >= 11 && age < 18) {
			ticket.setTotalCost(12);
			ticket.setTicketType(TicketType.Teen);
			ticket.setQuantity(1);
		} else if (age >= 0 && age < 11) {
			ticket.setTotalCost(5);
			ticket.setTicketType(TicketType.Children);
			ticket.setQuantity(1);
		}
		// throw error
		else {
			throw new RuntimeException("Invalid age");
		}
		return ticket;
	}

	@PostMapping(path = "/", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Response post(@RequestBody Body body) {
		Response response = new Response();
		response.setTransactionId(body.getTransactionId());
		for (int i = 0; i < body.getCustomers().length; i++) {
			Customer customer = body.getCustomers()[i];
			Ticket ticket = getTicketForAge(customer.getAge());
			response.addTicket(ticket);
		}
		return response;
	}

}
