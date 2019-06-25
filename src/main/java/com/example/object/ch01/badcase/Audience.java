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

    public Long buy(Ticket ticket) {
      return  bag.hold(ticket);
    }
}
