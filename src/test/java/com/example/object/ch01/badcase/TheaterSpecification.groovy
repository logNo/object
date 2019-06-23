package com.example.object.ch01.badcase

import com.example.object.SoldOutException
import spock.lang.Specification

/**
 * @author chulwoon.jang* @since 2019. 06. 21.
 */
class TheaterSpecification extends Specification {

    def "이벤트 당첨자 입장"() {
        given:
        def invitation = new Invitation()
        def bag = new Bag(invitation, 0)
        def audience = new Audience(bag)
        def ticketOffice = new TicketOffice(0, new Ticket(100), new Ticket(100))
        def ticketSeller = new TicketSeller(ticketOffice)
        def theater = new Theater(ticketSeller)

        when:
        theater.enter(audience)

        then:
        audience.getBag().hasTicket()
        ticketOffice.getAmount() == 0
    }

    def "이벤트 미당첨자 입장"() {
        given:
        def bag = new Bag(0)
        def audience = new Audience(bag)
        def ticketOffice = new TicketOffice(0, new Ticket(100), new Ticket(100))
        def ticketSeller = new TicketSeller(ticketOffice)
        def theater = new Theater(ticketSeller)

        when:
        theater.enter(audience)

        then:
        audience.getBag().hasTicket()
        ticketOffice.getAmount() == 100
    }

    /*
    기존 예제 문제점
    1. TC를 위해 입력되는 객체가 너무 많은듯 함 (given 절이 너무 길다.)
    2. getBag / hasTicket 처럼 `dont tell , ask` 가 지켜지지 않음.

    + dont tell, ask 는 지켜졌을지 모르겠으나, 내가 짠 코드로는 역할 분리가 안되어있었음.
    theater 가 ticketSeller / Audience 를 직접 제어하고 있었던 상황.
    책에서는 입장을 theater 로 하되, 초대권을 확인하고, 상품을 파는 역할을 seller 에게 맡기도록 했다.
    (이편이 더 맞는듯 함 )
     */

    def "티켓이 없을때"() {
        given:
        def bag = new Bag(0)
        def audience = new Audience(bag)
        def ticketOffice = new TicketOffice(0)
        def ticketSeller = new TicketSeller(ticketOffice)
        def theater = new Theater(ticketSeller)

        when:
        theater.enter(audience)

        then:
        def e = thrown(SoldOutException.class)
        e.message == "잔여티켓이 없습니다."
    }

    /**
     * 다만 현재의 구조는 theater 가 audience 와 ticketSeller 의 돈과 티켓을 직접 제어하는 구조이다.
     * 이는 과도한 의존성이 맺어지므로 피해야하는 상황이다.
     * (또한 극장에서 손님의 지갑에 직접 접근하지는 않으니까 ..)
     *
     * 구조가 변경되면서, Unit Test 의 대상도 변경이 필요할 것 같다 ..
     */
}
