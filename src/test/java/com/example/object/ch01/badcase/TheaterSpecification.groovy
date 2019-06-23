package com.example.object.ch01.badcase


import spock.lang.Specification

/**
 * @author chulwoon.jang* @since 2019. 06. 21.
 */
class TheaterSpecification extends Specification {

    def "이벤트 당첨자 입장"(){
        given:
        def invitation = new Invitation()
        def bag = new Bag(invitation,0)
        def audience = new Audience(bag)
        def ticketOffice = new TicketOffice(0,new Ticket(100),new Ticket(100))
        def ticketSeller = new TicketSeller(ticketOffice)
        def theater = new Theater(ticketSeller)

        when:
        theater.enter(audience)

        then:
        audience.getBag().hasTicket()
        ticketOffice.getAmount() == 0
    }

    def "이벤트 미당첨자 입장"(){
        given:
        def bag = new Bag(0)
        def audience = new Audience(bag)
        def ticketOffice = new TicketOffice(0,new Ticket(100),new Ticket(100))
        def ticketSeller = new TicketSeller(ticketOffice)
        def theater = new Theater(ticketSeller)

        when:
        theater.enter(audience)
        // spock mocking 좀 찾아봐야겟다.

        then:
        audience.getBag().hasTicket()
        ticketOffice.getAmount() == 100
    }

    /*
    기존 예제 문제점
    1. TC를 위해 입력되는 객체가 너무 많은듯 함 (given 절이 너무 길다.)
    2. getBag / hasTicket 처럼 `dont tell , ask` 가 지켜지지 않음.
     */
}
