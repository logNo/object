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
		Ticket ticket = ticketSeller.getTicket();
		ticketSeller.sellTo(audience.buy(ticket));
	}

}
