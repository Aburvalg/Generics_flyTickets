package netology.ticketsManager;

import netology.domain.FlyTicket;
import netology.repository.TicketsRepository;

import java.util.Comparator;

public class FlyTicketsManager {
    private FlyTicket[] tickets = new FlyTicket[0];
    private TicketsRepository repository;

    public FlyTicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(FlyTicket ticket) {
        repository.save(ticket);
    }

    public FlyTicket[] searchByFromTo(String aeroportFrom, String aeroportTo) {
        FlyTicket[] result = new FlyTicket[0]; // тут будем хранить подошедшие запросу продукты
        for (FlyTicket ticket : repository.showAll()) {
            if (ticket.matches(aeroportFrom, aeroportTo)) {
                int length = result.length + 1;    // "добавляем в конец" массива result продукт product
                FlyTicket[] tmp = new FlyTicket[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                int lastIndex = tmp.length - 1;
                tmp[lastIndex] = ticket;
                result = tmp;
            }
        }
        return result;
    }

    public FlyTicket[] findAllWithSearch(String aeroportFrom, String aeroportTo) {
        FlyTicket[] result = new FlyTicket[tickets.length];
        for (FlyTicket ticket : searchByFromTo(aeroportFrom, aeroportTo)) {
            int length = result.length + 1;    // "добавляем в конец" массива result продукт product
            FlyTicket[] tmp = new FlyTicket[length];
            System.arraycopy(result, 0, tmp, 0, result.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = ticket;
            result = tmp;

        }
        return result;
    }

    public FlyTicket[] findAllSearchWithComparator(String aeroportFrom, String aeroportTo, Comparator <FlyTicket> comparator) {
        FlyTicket[] result = new FlyTicket[tickets.length];
        for (FlyTicket ticket : searchByFromTo(aeroportFrom, aeroportTo)) {
            int length = result.length + 1;    // "добавляем в конец" массива result продукт product
            FlyTicket[] tmp = new FlyTicket[length];
            System.arraycopy(result, 0, tmp, 0, result.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = ticket;
            result = tmp;

        }
        return result;
    }


}
