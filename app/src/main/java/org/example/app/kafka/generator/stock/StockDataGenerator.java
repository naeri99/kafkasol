package org.example.app.kafka.generator.stock;

import org.example.app.kafka.generator.AbstractSampleDataGenerator;
import org.example.app.model.stock.Stock;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Arrays;
import java.util.List;


public abstract class StockDataGenerator extends AbstractSampleDataGenerator {
    protected static final List<String> SYMBOLS = Arrays.asList("AAPL", "GOOGL", "MSFT", "AMZN", "FB");

    public StockDataGenerator(KafkaProducer<String, String> producer) {
        super(producer);
    }

    protected abstract Stock createStock();
}
