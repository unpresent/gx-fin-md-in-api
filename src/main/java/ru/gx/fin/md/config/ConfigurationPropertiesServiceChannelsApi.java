package ru.gx.fin.md.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@ConfigurationProperties(prefix = "service.channels-api")
@Getter
@Setter
public class ConfigurationPropertiesServiceChannelsApi {

    @NestedConfigurationProperty
    public Streams mdStreams;

    @Getter
    @Setter
    public static class Streams {
        @NestedConfigurationProperty
        public Enabled mdTradesV1;

        @NestedConfigurationProperty
        public Enabled mdOrdersV1;

        @NestedConfigurationProperty
        public Enabled mdDealsV1;
    }

    @Getter
    @Setter
    public static class Enabled {
        public boolean enabled = true;
    }
}
