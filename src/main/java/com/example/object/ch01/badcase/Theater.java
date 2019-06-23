package com.example.object.ch01.badcase;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
public class Theater {
	
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience){
		if(audience.getBag().hasInvitation()){
			Ticket ticket = ticketSeller.getTicketOffice().getTickets();
			audience.getBag().setTicket(ticket);
			return;
		}
		Ticket ticket = ticketSeller.getTicketOffice().getTickets();
		audience.getBag().minusAmount(ticket.getFee());
		ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
		audience.getBag().setTicket(ticket);
	}
}
