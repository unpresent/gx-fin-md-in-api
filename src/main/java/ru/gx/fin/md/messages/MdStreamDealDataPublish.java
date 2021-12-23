package ru.gx.fin.md.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.dto.MdDeal;
import ru.gx.fin.md.dto.MdTrade;

import java.util.Arrays;

@SuppressWarnings("unused")
public class MdStreamDealDataPublish
        extends AbstractDataPublish<MdStreamDealDataPublish.MdStreamDealDataPublishBody> {
    public static final int V1 = 1;
    public static final int[] SUPPORTED_VERSIONS = {V1};

    private static boolean initialized = false;

    public static void staticInit() {
        if (initialized) {
            return;
        }
        initialized = true;
        Arrays.stream(SUPPORTED_VERSIONS).forEach(version ->
                MessageTypesRegistrator.registerType(
                        MessageKind.DataPublish,
                        MdMessageTypes.Streams.DEALS,
                        version,
                        MdStreamDealDataPublish.class,
                        MdStreamDealDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public MdStreamDealDataPublish(
            @JsonProperty("header") @NotNull final DataPublishHeader header,
            @JsonProperty("body") @NotNull final MdStreamDealDataPublish.MdStreamDealDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class MdStreamDealDataPublishBody extends AbstractMessageBodyDataObject<MdDeal> {
        @JsonCreator
        public MdStreamDealDataPublishBody(
                @JsonProperty("dataObject") @NotNull final MdDeal dataObject
        ) {
            super(dataObject);
        }
    }
}
