package org.example.app.kafka.producer;

import org.example.app.kafka.config.KafkaProperties;
import org.example.app.kafka.generator.SampleDataGenerator;
import org.example.app.kafka.producer.factory.DataGeneratorFactory;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.Properties;

public class SampleDataProducer {

    public void testKafka() throws Exception {
 

        // Get the generator type from the command-line arguments
        // "StockSingle", "StockGroup", "StockSector", "StockTransaction", "PortfolioSingle"
        String generatorType = "StockSingle";

        // Create producer properties
        Properties properties = new KafkaProperties().setSourceTopic("my-topic").setGroupId("my-group").build();

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Create a DataGenerator and generate and send data
        SampleDataGenerator dataGenerator = DataGeneratorFactory.createDataGenerator(producer, generatorType);
        dataGenerator.generateAndSend();

        // Flush and close producer
        producer.flush();
        producer.close();
    }



    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please provide a generator type as an argument");
        }

        // Get the generator type from the command-line arguments
        // "StockSingle", "StockGroup", "StockSector", "StockTransaction", "PortfolioSingle"
        String generatorType = args[0];

        // Create producer properties
        Properties properties = new KafkaProperties().build();

        // Create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Create a DataGenerator and generate and send data
        SampleDataGenerator dataGenerator = DataGeneratorFactory.createDataGenerator(producer, generatorType);
        dataGenerator.generateAndSend();

        // Flush and close producer
        producer.flush();
        producer.close();
    }
}
