package org.example.app.model.commodity;

public class GoldCommodity extends Commodity {
    public GoldCommodity() {
    }

    public GoldCommodity(String exchange, double price, long timestamp) {
        this.exchange = exchange;
        this.commodity = "XAU";
        this.price = price;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "GoldCommodity{" +
                "exchange='" + getExchange() + '\'' +
                ", commodity='" + getCommodity() + '\'' +
                ", price=" + getPrice() +
                ", timestamp=" + getTimestamp() +
                '}';
    }
}