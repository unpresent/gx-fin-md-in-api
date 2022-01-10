package ru.gx.fin.md.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.dto.MdOrder;

import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class MdStreamOrderDataPublish
        extends AbstractMessage<MdStreamOrderDataPublish.MdStreamOrderDataPublishBody> {
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
                        MdMessageTypes.Streams.ORDERS,
                        version,
                        MdStreamOrderDataPublish.class,
                        MdStreamOrderDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public MdStreamOrderDataPublish(
            @JsonProperty("header") @NotNull final StandardMessageHeader header,
            @JsonProperty("body") @NotNull final MdStreamOrderDataPublish.MdStreamOrderDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class MdStreamOrderDataPublishBody extends AbstractMessageBodyDataObject<MdOrder> {
        @JsonCreator
        public MdStreamOrderDataPublishBody(
                @JsonProperty("dataObject") @NotNull final MdOrder dataObject
        ) {
            super(dataObject);
        }
    }
}
