package io.quarkuscoffeeshop.coffeeshop.counter.domain;

import io.quarkuscoffeeshop.coffeeshop.domain.Order;
import io.quarkuscoffeeshop.coffeeshop.domain.valueobjects.OrderIn;
import io.quarkuscoffeeshop.coffeeshop.domain.valueobjects.OrderUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderEventResult {

    private Order order;

    private List<OrderIn> baristaTickets;

    private List<OrderIn> kitchenTickets;

    private List<OrderUpdate> orderUpdates;

    public OrderEventResult() {
    }

    public OrderEventResult(Order order, List<OrderIn> baristaTickets, List<OrderIn> kitchenTickets, List<OrderUpdate> orderUpdates) {
        this.order = order;
        this.baristaTickets = baristaTickets;
        this.kitchenTickets = kitchenTickets;
        this.orderUpdates = orderUpdates;
    }

    public void addUpdate(final OrderUpdate orderUpdate) {
        if (this.orderUpdates == null) {
            this.orderUpdates = new ArrayList<>();
        }
        this.orderUpdates.add(orderUpdate);
    }

    public void addBaristaTicket(final OrderIn orderIn) {
        if (this.baristaTickets == null) {
            this.baristaTickets = new ArrayList<>();
        }
        this.baristaTickets.add(orderIn);
    }

    public void addKitchenTicket(final OrderIn orderIn) {
        if (this.kitchenTickets == null) {
            this.kitchenTickets = new ArrayList<>();
        }
        this.kitchenTickets.add(orderIn);
    }

    public Optional<List<OrderIn>> getBaristaTickets() {
        return Optional.ofNullable(baristaTickets);
    }

    public Optional<List<OrderIn>> getKitchenTickets() {
        return Optional.ofNullable(kitchenTickets);
    }

    // Generated

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setBaristaTickets(List<OrderIn> baristaTickets) {
        this.baristaTickets = baristaTickets;
    }

    public void setKitchenTickets(List<OrderIn> kitchenTickets) {
        this.kitchenTickets = kitchenTickets;
    }

    public List<OrderUpdate> getOrderUpdates() {
        return orderUpdates;
    }

    public void setOrderUpdates(List<OrderUpdate> orderUpdates) {
        this.orderUpdates = orderUpdates;
    }
}
