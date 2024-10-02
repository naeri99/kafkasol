package org.example.app.kafka.config.factory.stock;

import org.example.app.kafka.config.KafkaSourceSinkHelper;
import org.example.app.kafka.config.factory.SourceFactory;
import org.example.app.kafka.serde.stock.StockClassKafkaRecordDeserializationSchema;
import org.example.app.model.stock.Stock;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.Properties;

public class StockSourceFactory implements SourceFactory<Stock> {
    @Override
    public KafkaSource<Stock> createSource(Properties properties) {
        return KafkaSourceSinkHelper.createKafkaSource(properties, new StockClassKafkaRecordDeserializationSchema());
    }
}
