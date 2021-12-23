package ru.gx.fin.md.config;

@SuppressWarnings("unused")
public abstract class MdChannelNames {
    public abstract static class Streams {
        public static final String TRADES_V1 = "md-streams.md-trades-v1";
        public static final String ORDERS_V1 = "md-streams.md-orders-v1";
        public static final String DEALS_V1 = "md-streams.md-deals-v1";
    }
}
