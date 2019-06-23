package com.example.object.ch01.badcase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author chulwoon.jang
 * @since 2019. 06. 20.
 */
public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, Ticket... tickets) {
        this.amount = amount;
        this.tickets.addAll(Arrays.asList(tickets));
    }

    public Optional<Ticket> getTicket() {
        if (tickets.size() < 1) {
            return Optional.empty();
        }
        return Optional.of(tickets.remove(0));
    }

    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    public void plusAmount(Long amount) {
        this.amount += amount;
    }

    public Long getAmount() {
        return amount;
    }
}
