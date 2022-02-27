package netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

@NoArgsConstructor
@Data
@AllArgsConstructor

public class FlyTicket implements Comparable<FlyTicket> {
    private int id;
    private int cost;
    private String aeroportFrom;
    private String aeroportTo;
    private int flyTime; // minutes


    @Override
    public int compareTo(@NotNull FlyTicket o) {
        return this.cost - o.cost;
    }

    public boolean matches(String aeroportFrom, String aeroportTo) {
        if (getAeroportFrom().contains(aeroportFrom) && getAeroportTo().contains(aeroportTo)) {
            return true;
        } else {
            return false;
        }
    }

    public class TicketByTimeAscComparator implements Comparator <FlyTicket> {
        public int compare(FlyTicket o1, FlyTicket o2) {
            return o1.getFlyTime() - o2.getFlyTime();
        }
    }

}
