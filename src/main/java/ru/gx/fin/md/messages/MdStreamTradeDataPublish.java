package ru.gx.fin.md.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.dto.MdTrade;

import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class MdStreamTradeDataPublish
        extends AbstractMessage<MdStreamTradeDataPublish.MdStreamTradeDataPublishBody> {
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
                        MdMessageTypes.Streams.TRADES,
                        version,
                        MdStreamTradeDataPublish.class,
                        MdStreamTradeDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public MdStreamTradeDataPublish(
            @JsonProperty("header") @NotNull final StandardMessageHeader header,
            @JsonProperty("body") @NotNull final MdStreamTradeDataPublish.MdStreamTradeDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class MdStreamTradeDataPublishBody extends AbstractMessageBodyDataObject<MdTrade> {
        @JsonCreator
        public MdStreamTradeDataPublishBody(
                @JsonProperty("dataObject") @NotNull final MdTrade dataObject
        ) {
            super(dataObject);
        }
    }
}
