package org.example.app.kafka.config;

import org.example.app.kafka.config.factory.SourceFactory;
import org.example.app.kafka.config.factory.portfolio.PortfolioSourceFactory;
import org.example.app.kafka.config.factory.primitive.StringSourceFactory;
import org.example.app.kafka.config.factory.stock.StockSourceFactory;
import org.example.app.kafka.config.factory.stock.StockTransactionSourceFactory;
import org.example.app.kafka.config.factory.stock.StockWithCountSourceFactory;
import org.example.app.model.portfolio.Portfolio;
import org.example.app.model.stock.Stock;
import org.example.app.model.stock.StockTransaction;
import org.example.app.model.stock.StockWithCount;
import org.apache.flink.connector.kafka.source.KafkaSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class KafkaSourceSink {
    private static final Map<Class<?>, SourceFactory<?>> factories = new HashMap<>();

    static {
        factories.put(Stock.class, new StockSourceFactory());
        factories.put(String.class, new StringSourceFactory());
        factories.put(StockTransaction.class, new StockTransactionSourceFactory());
        factories.put(StockWithCount.class, new StockWithCountSourceFactory());
        factories.put(Portfolio.class, new PortfolioSourceFactory());
    }

    @SuppressWarnings("unchecked")
    public static <T> KafkaSource<T> createSource(Properties properties, Class<T> classType) {
        SourceFactory<T> factory = (SourceFactory<T>) factories.get(classType);
        if (factory == null) {
            throw new IllegalArgumentException("Unsupported class type");
        }
        return factory.createSource(properties);
    }
}
