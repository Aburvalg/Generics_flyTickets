package netology.ticketsManager;

import netology.domain.FlyTicket;
import netology.repository.TicketsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FlyTicketsManagerTest {
    private TicketsRepository repo = new TicketsRepository();
    private FlyTicketsManager manager = new FlyTicketsManager(repo);

    private FlyTicket first = new FlyTicket(1, 100, "NUR", "VKO", 60);
    private FlyTicket second = new FlyTicket(2, 150, "UFA", "VKO", 80);
    private FlyTicket third = new FlyTicket(3, 350, "DME", "AST", 70);

    private FlyTicket forth = new FlyTicket(4, 200, "DME", "AST", 100);
    private FlyTicket fifth = new FlyTicket(5, 400, "DME", "AST", 100);
    private FlyTicket sixth = new FlyTicket(6, 100, "DME", "AST", 90);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldFindAllWithSort() {
        manager.add(fifth);
        manager.add(sixth);
        manager.add(forth);

        FlyTicket[] expected = {sixth,forth, third, fifth};
        FlyTicket[] actual = manager.findAllWithSearchAndSort("DME", "AST");

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldShowAllByFromToEmptyRepo() {
        repo.removeById(1);
        repo.removeById(2);
        repo.removeById(3);

        FlyTicket[] expected = {};
        FlyTicket[] actual = manager.findAllWithSearchAndSort("DME", "AST");

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldShowAllByFromToOneTicket() {

        FlyTicket[] expected = {third};
        FlyTicket[] actual = manager.findAllWithSearchAndSort("DME", "AST");

        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }


}