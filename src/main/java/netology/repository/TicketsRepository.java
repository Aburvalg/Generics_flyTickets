package netology.repository;

import netology.domain.FlyTicket;

public class TicketsRepository {

    private FlyTicket[] tickets = new FlyTicket[0];

    public void save(FlyTicket ticket) {
        int length = tickets.length + 1;
        FlyTicket[] tmp = new FlyTicket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public FlyTicket[] showAll() {
        return tickets;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        FlyTicket[] tmp = new FlyTicket[length];
        int index = 0;
        for (FlyTicket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }


}
