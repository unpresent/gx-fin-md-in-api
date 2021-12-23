package ru.gx.fin.md.config;

@SuppressWarnings("unused")
public abstract class MdMessageTypes {

    public abstract static class Streams {
        public static final String TRADES = "MD:STREAM-PUBLISH:TRADES";
        public static final String ORDERS = "MD:STREAM-PUBLISH:ORDERS";
        public static final String DEALS = "MD:STREAM-PUBLISH:DEALS";
    }
}
