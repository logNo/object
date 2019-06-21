package com.example.object.ch01.badcase

import spock.lang.Specification

/**
 * @author chulwoon.jang* @since 2019. 06. 21.
 */
class TheaterSpecification extends Specification {
    
    /*
    if(audience.getBag().hasInvitaion()){
			Ticket ticket = ticketSeller.getTicketOffice().getTickets();
			audience.getBag().setTicket(ticket);
			return;
		}
		Ticket ticket = ticketSeller.getTicketOffice().getTickets();
		audience.getBag().minusAmount(ticket.getFee());
		ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
		audience.getBag().setTicket(ticket);
     */
    
    def "이벤트 당첨자 입장"(){
        // spock mocking 좀 찾아봐야겟다. 
    }
}
