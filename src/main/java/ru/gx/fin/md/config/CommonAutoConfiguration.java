package ru.gx.fin.md.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gx.fin.md.channels.*;
import ru.gx.fin.md.keyextractors.*;
import ru.gx.fin.md.messages.*;

@Configuration
@EnableConfigurationProperties(ConfigurationPropertiesServiceChannelsApi.class)
public class CommonAutoConfiguration {
    private static final String DOT_ENABLED = ".enabled";

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamTradeDataPublishChannelApiV1 mdStreamTradeDataPublishChannelApiV1() {
        MdStreamTradeDataPublish.staticInit();
        return new MdStreamTradeDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamErrorTradeDataPublishChannelApiV1 mdStreamErrorTradeDataPublishChannelApiV1() {
        MdStreamErrorTradeDataPublish.staticInit();
        return new MdStreamErrorTradeDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public MdTradeKeyExtractor mdTradeKeyExtractor() {
        return new MdTradeKeyExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public MdErrorTradeKeyExtractor mdErrorTradeKeyExtractor() {
        return new MdErrorTradeKeyExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamOrderDataPublishChannelApiV1 mdStreamOrderDataPublishChannelApiV1() {
        MdStreamOrderDataPublish.staticInit();
        return new MdStreamOrderDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamErrorOrderDataPublishChannelApiV1 mdStreamErrorOrderDataPublishChannelApiV1() {
        MdStreamErrorOrderDataPublish.staticInit();
        return new MdStreamErrorOrderDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public MdOrderKeyExtractor mdOrderKeyExtractor() {
        return new MdOrderKeyExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public MdErrorOrderKeyExtractor mdErrorOrderKeyExtractor() {
        return new MdErrorOrderKeyExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamDealDataPublishChannelApiV1 mdStreamDealDataPublishChannelApiV1() {
        MdStreamDealDataPublish.staticInit();
        return new MdStreamDealDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public MdStreamErrorDealDataPublishChannelApiV1 mdStreamErrorDealDataPublishChannelApiV1() {
        MdStreamErrorDealDataPublish.staticInit();
        return new MdStreamErrorDealDataPublishChannelApiV1();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public MdDealKeyExtractor mdDealKeyExtractor() {
        return new MdDealKeyExtractor();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ERROR_DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public MdErrorDealKeyExtractor mdErrorDealKeyExtractor() {
        return new MdErrorDealKeyExtractor();
    }
}
