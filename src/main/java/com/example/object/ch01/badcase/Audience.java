package com.example.object.ch01.badcase;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
@AllArgsConstructor
@Getter
public class Audience {
	private Bag bag;


	public boolean hasInvitation(){
		return bag.hasInvitation();
	}

	public void setTicket(Ticket ticket){
		bag.setTicket(ticket);
	}

	public void payForTicket(long amount){
		bag.minusAmount(amount);
	}
}
