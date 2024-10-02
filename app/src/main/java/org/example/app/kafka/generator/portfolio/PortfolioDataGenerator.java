package org.example.app.kafka.generator.portfolio;

import org.example.app.kafka.generator.AbstractSampleDataGenerator;
import org.example.app.model.portfolio.Portfolio;
import org.apache.kafka.clients.producer.KafkaProducer;

public abstract class PortfolioDataGenerator extends AbstractSampleDataGenerator {
    public PortfolioDataGenerator(KafkaProducer<String, String> producer) {
        super(producer);
    }

    protected abstract Portfolio createPortfolio();
}
