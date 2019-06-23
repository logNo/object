package com.example.object.ch01.badcase;

import com.example.object.SoldOutException;
import lombok.extern.java.Log;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
@Log
public class Theater {
	
	private TicketSeller ticketSeller;

	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}

	public void enter(Audience audience) throws SoldOutException {
		if(audience.hasInvitation()){
			Ticket ticket = ticketSeller.getTicket();
			audience.setTicket(ticket);
			return;
		}
		purchaseTicket(audience);
	}

	private void purchaseTicket(Audience audience) throws SoldOutException {
			Ticket ticket = ticketSeller.getTicket();
			audience.payForTicket(ticket.getFee());
			ticketSeller.plusAmount(ticket.getFee());
			audience.setTicket(ticket);

	}
}
