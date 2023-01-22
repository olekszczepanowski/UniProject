package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class Medicine implements Serializable {

    private String name;
    private LocalDate bestBeforeEnd;
    private String forCondition;
    private int price;

    public Medicine(String name, LocalDate bestBeforeEnd, String forCondition, int price) {
        this.name = name;
        this.bestBeforeEnd = bestBeforeEnd;
        this.forCondition = forCondition;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBestBeforeEnd() {
        return bestBeforeEnd;
    }

    public void setBestBeforeEnd(LocalDate bestBeforeEnd) {
        this.bestBeforeEnd = bestBeforeEnd;
    }

    public String getForCondition() {
        return forCondition;
    }

    public void setForCondition(String forCondition) {
        this.forCondition = forCondition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "[name: " + name + ", " +
                "best before end: " + bestBeforeEnd + ", " +
                "best for condition: " + forCondition + ", " +
                "price: " + price + "]";
    }
}
