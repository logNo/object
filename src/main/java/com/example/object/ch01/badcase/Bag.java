package com.example.object.ch01.badcase;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
public class Bag {
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;

	public Bag(Long amount) {
		this(null, amount);
	}

	public Bag(Invitation invitation, Long amount) {
		this.amount = amount;
		this.invitation = invitation;
	}

	private boolean hasInvitation() {
		return invitation != null;
	}

	boolean hasTicket() {
		return ticket != null;
	}

	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

	private void plusAmount(Long amount) {
		this.amount += amount;
	}

    public long hold(Ticket ticket) {
		if (this.hasInvitation()) {
			this.setTicket(ticket);
			return 0L;
		}
		this.minusAmount(ticket.getFee());
		this.setTicket(ticket);
		return ticket.getFee();
    }
}
