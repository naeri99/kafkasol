package org.example.app.kafka.producer.factory;

import org.example.app.kafka.generator.SampleDataGenerator;
import org.example.app.kafka.generator.portfolio.PortfolioSingleDataGenerator;
import org.example.app.kafka.generator.stock.StockGroupDataGenerator;
import org.example.app.kafka.generator.stock.StockSectorDataGenerator;
import org.example.app.kafka.generator.stock.StockSingleDataGenerator;
import org.example.app.kafka.generator.stock.StockTransactionDataGenerator;
import org.apache.kafka.clients.producer.KafkaProducer;

public class DataGeneratorFactory {
    public static SampleDataGenerator createDataGenerator(KafkaProducer<String, String> producer, String generatorType) {
        switch (generatorType) {
            case "StockSingle":
                return new StockSingleDataGenerator(producer);
            case "StockGroup":
                return new StockGroupDataGenerator(producer);
            case "StockSector":
                return new StockSectorDataGenerator(producer);
            case "StockTransaction":
                return new StockTransactionDataGenerator(producer);
            case "PortfolioSingle":
                return new PortfolioSingleDataGenerator(producer);
            default:
                throw new IllegalArgumentException("Unknown generator type: " + generatorType);
        }
    }
}
