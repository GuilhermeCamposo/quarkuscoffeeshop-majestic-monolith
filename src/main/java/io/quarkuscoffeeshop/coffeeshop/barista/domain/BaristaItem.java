package io.quarkuscoffeeshop.coffeeshop.barista.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class BaristaItem extends PanacheEntity {

    private String item;

    private Instant timeIn;

    private Instant timeUp;

    public BaristaItem(String item, Instant timeIn, Instant timeUp) {
        this.item = item;
        this.timeIn = timeIn;
        this.timeUp = timeUp;
    }

    public BaristaItem() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaristaItem{");
        sb.append("item='").append(item).append('\'');
        sb.append(", timeIn=").append(timeIn);
        sb.append(", timeUp=").append(timeUp);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaristaItem that = (BaristaItem) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (timeIn != null ? !timeIn.equals(that.timeIn) : that.timeIn != null) return false;
        return timeUp != null ? timeUp.equals(that.timeUp) : that.timeUp == null;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (timeIn != null ? timeIn.hashCode() : 0);
        result = 31 * result + (timeUp != null ? timeUp.hashCode() : 0);
        return result;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Instant getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(Instant timeIn) {
        this.timeIn = timeIn;
    }

    public Instant getTimeUp() {
        return timeUp;
    }

    public void setTimeUp(Instant timeUp) {
        this.timeUp = timeUp;
    }
}
