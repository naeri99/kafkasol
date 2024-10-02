package org.example.app.kafka.config.factory.stock;


import org.example.app.kafka.config.KafkaSourceSinkHelper;
import org.example.app.kafka.config.factory.SourceFactory;
import com.fastcampus.streaming.flinkcourse.kafka.serde.stock.StockWithCountClassKafkaRecordDeserializationSchema;
import com.fastcampus.streaming.flinkcourse.model.stock.StockWithCount;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.Properties;

public class StockWithCountSourceFactory implements SourceFactory<StockWithCount> {
    @Override
    public KafkaSource<StockWithCount> createSource(Properties properties) {
        return KafkaSourceSinkHelper.createKafkaSource(properties, new StockWithCountClassKafkaRecordDeserializationSchema());
    }
}
