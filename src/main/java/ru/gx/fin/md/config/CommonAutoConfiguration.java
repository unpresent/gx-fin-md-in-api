package ru.gx.fin.md.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.gx.fin.md.channels.MdStreamDealDataPublishChannelApiV1;
import ru.gx.fin.md.channels.MdStreamOrderDataPublishChannelApiV1;
import ru.gx.fin.md.channels.MdStreamTradeDataPublishChannelApiV1;
import ru.gx.fin.md.keyextractors.MdDealKeyExtractor;
import ru.gx.fin.md.keyextractors.MdOrderKeyExtractor;
import ru.gx.fin.md.keyextractors.MdTradeKeyExtractor;
import ru.gx.fin.md.messages.MdStreamDealDataPublish;
import ru.gx.fin.md.messages.MdStreamOrderDataPublish;
import ru.gx.fin.md.messages.MdStreamTradeDataPublish;

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
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.TRADES_V1 + DOT_ENABLED, havingValue = "true")
    public MdTradeKeyExtractor mdTradeKeyExtractor() {
        return new MdTradeKeyExtractor();
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
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.ORDERS_V1 + DOT_ENABLED, havingValue = "true")
    public MdOrderKeyExtractor securityKeyExtractor() {
        return new MdOrderKeyExtractor();
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
    @ConditionalOnProperty(value = "service.channels-api." + MdChannelNames.Streams.DEALS_V1 + DOT_ENABLED, havingValue = "true")
    public MdDealKeyExtractor derivativeKeyExtractor() {
        return new MdDealKeyExtractor();
    }
}
