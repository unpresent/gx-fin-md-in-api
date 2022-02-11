package ru.gx.fin.md.config;

@SuppressWarnings("unused")
public abstract class MdMessageTypes {

    public abstract static class Streams {
        public static final String TRADES = "MD:STREAM-PUBLISH:TRADES";
        public static final String ORDERS = "MD:STREAM-PUBLISH:ORDERS";
        public static final String DEALS = "MD:STREAM-PUBLISH:DEALS";

        public static final String ERROR_TRADES = "MD:STREAM-PUBLISH:ERROR-TRADES";
        public static final String ERROR_ORDERS = "MD:STREAM-PUBLISH:ERROR-ORDERS";
        public static final String ERROR_DEALS = "MD:STREAM-PUBLISH:ERROR-DEALS";
    }
}
