package com.example.object.ch01.badcase;

import lombok.Getter;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
@Getter
public class TicketSeller {
	
	private TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
}
