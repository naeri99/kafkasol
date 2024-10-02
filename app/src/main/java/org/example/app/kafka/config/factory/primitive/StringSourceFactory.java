package org.example.app.kafka.config.factory.primitive;

import org.example.app.kafka.config.KafkaSourceSinkHelper;
import org.example.app.kafka.config.factory.SourceFactory;
import org.example.app.kafka.serde.string.StringKafkaRecordDeserializationSchema;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.Properties;

public class StringSourceFactory implements SourceFactory<String> {
    @Override
    public KafkaSource<String> createSource(Properties properties) {
        return KafkaSourceSinkHelper.createKafkaSource(properties, new StringKafkaRecordDeserializationSchema());
    }
}
