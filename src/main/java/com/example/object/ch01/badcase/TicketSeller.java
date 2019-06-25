package com.example.object.ch01.badcase;

import com.example.object.SoldOutException;
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

    public Ticket getTicket() throws SoldOutException {
        return ticketOffice
                .getTicket()
                .orElseThrow(() -> new SoldOutException("잔여티켓이 없습니다."));
    }

    public void plusAmount(long amount) {
        ticketOffice.plusAmount(amount);
    }

    public void sellTo(Long payment) {
        plusAmount(payment);
    }
}
