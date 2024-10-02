package org.example.app.kafka.config.factory.portfolio;

import org.example.app.kafka.config.KafkaSourceSinkHelper;
import org.example.app.kafka.config.factory.SourceFactory;
import org.example.app.kafka.serde.portfolio.PortfolioClassKafkaRecordDeserializationSchema;
import org.example.app.model.portfolio.Portfolio;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.Properties;

public class PortfolioSourceFactory implements SourceFactory<Portfolio> {
    @Override
    public KafkaSource<Portfolio> createSource(Properties properties) {
        return KafkaSourceSinkHelper.createKafkaSource(properties, new PortfolioClassKafkaRecordDeserializationSchema());
    }
}
