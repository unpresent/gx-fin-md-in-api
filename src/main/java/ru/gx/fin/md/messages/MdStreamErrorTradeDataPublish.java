package ru.gx.fin.md.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.dto.MdErrorTrade;

import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class MdStreamErrorTradeDataPublish
        extends AbstractMessage<MdStreamErrorTradeDataPublish.MdStreamErrorTradeDataPublishBody> {
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
                        MdMessageTypes.Streams.ERROR_TRADES,
                        version,
                        MdStreamErrorTradeDataPublish.class,
                        MdStreamErrorTradeDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public MdStreamErrorTradeDataPublish(
            @JsonProperty("header") @NotNull final StandardMessageHeader header,
            @JsonProperty("body") @NotNull final MdStreamErrorTradeDataPublish.MdStreamErrorTradeDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class MdStreamErrorTradeDataPublishBody extends AbstractMessageBodyDataObject<MdErrorTrade> {
        @JsonCreator
        public MdStreamErrorTradeDataPublishBody(
                @JsonProperty("dataObject") @NotNull final MdErrorTrade dataObject
        ) {
            super(dataObject);
        }
    }
}
