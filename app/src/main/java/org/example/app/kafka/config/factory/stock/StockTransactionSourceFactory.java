package org.example.app.kafka.config.factory.stock;


import org.example.app.kafka.config.KafkaSourceSinkHelper;
import org.example.app.kafka.config.factory.SourceFactory;
import com.fastcampus.streaming.flinkcourse.kafka.serde.stock.StockTransactionClassKafkaRecordDeserializationSchema;
import com.fastcampus.streaming.flinkcourse.model.stock.StockTransaction;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.Properties;

public class StockTransactionSourceFactory implements SourceFactory<StockTransaction> {
    @Override
    public KafkaSource<StockTransaction> createSource(Properties properties) {
        return KafkaSourceSinkHelper.createKafkaSource(properties, new StockTransactionClassKafkaRecordDeserializationSchema());
    }
}
