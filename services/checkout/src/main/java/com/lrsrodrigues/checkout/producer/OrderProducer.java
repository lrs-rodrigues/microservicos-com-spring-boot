package com.lrsrodrigues.checkout.producer;

import com.lrsrodrigues.checkout.entities.Kart;
import com.lrsrodrigues.checkout.entities.KartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProducer {

    @Autowired
    private KafkaTemplate<String, Kart> kafkaTemplate;

    public void send(Integer orderId, List<KartItem> kartItems) {
        kafkaTemplate.send("order", new Kart(orderId, kartItems));
    }
}
