package io.quarkuscoffeeshop.coffeeshop.barista;

import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.quarkuscoffeeshop.coffeeshop.barista.api.Barista;
import io.quarkuscoffeeshop.coffeeshop.counter.OrderServiceImpl;
import io.quarkuscoffeeshop.coffeeshop.counter.api.OrderService;
import io.quarkuscoffeeshop.coffeeshop.domain.Item;
import io.quarkuscoffeeshop.coffeeshop.domain.valueobjects.OrderIn;
import io.quarkuscoffeeshop.coffeeshop.domain.valueobjects.OrderUp;
import io.quarkuscoffeeshop.coffeeshop.domain.valueobjects.OrderUpdate;
import io.smallrye.mutiny.Multi;
import io.quarkuscoffeeshop.utils.JsonUtil;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static io.quarkuscoffeeshop.utils.JsonUtil.fromJson;
import static io.quarkuscoffeeshop.utils.JsonUtil.fromJsonToOrderUp;
import static org.awaitility.Awaitility.await;
import static io.quarkuscoffeeshop.coffeeshop.infrastructure.EventBusTopics.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class BaristaTest {

    private static final Logger logger = LoggerFactory.getLogger(BaristaTest.class);

    @Inject
    Barista barista;

    @Inject
    EventBus eventBus;

    @InjectMock
    OrderService orderService;

    List<OrderUp> orderUpMessages = new ArrayList<>();

    @BeforeEach
    public void setUp() {

        eventBus.consumer(ORDERS_UP)
                .handler(message -> {
                    logger.info("message received: {}", message.body().toString());
                    assertNotNull(message);
                    orderUpMessages.add(fromJsonToOrderUp(message.body().toString()));
                });
    }

    @Test
    public void testMakeBlackCoffee() {
        OrderIn orderIn = new OrderIn(UUID.randomUUID().toString(), UUID.randomUUID().toString(), Item.COFFEE_BLACK, "Spock");

        eventBus.publish(BARISTA_IN, JsonUtil.toJson(orderIn));
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            assertNull(e);
        }
        assertEquals(1, orderUpMessages.size());
    }

}
