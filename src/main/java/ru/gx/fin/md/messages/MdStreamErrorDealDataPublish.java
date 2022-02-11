package ru.gx.fin.md.messages;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.messaging.*;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.dto.MdErrorDeal;

import java.util.Arrays;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public class MdStreamErrorDealDataPublish
        extends AbstractMessage<MdStreamErrorDealDataPublish.MdStreamErrorDealDataPublishBody> {
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
                        MdMessageTypes.Streams.ERROR_DEALS,
                        version,
                        MdStreamErrorDealDataPublish.class,
                        MdStreamErrorDealDataPublishBody.class
                )
        );
    }

    @JsonCreator
    public MdStreamErrorDealDataPublish(
            @JsonProperty("header") @NotNull final StandardMessageHeader header,
            @JsonProperty("body") @NotNull final MdStreamErrorDealDataPublish.MdStreamErrorDealDataPublishBody body,
            @JsonProperty("correlation") final @Nullable MessageCorrelation correlation
    ) {
        super(header, body, correlation);
    }

    public static class MdStreamErrorDealDataPublishBody extends AbstractMessageBodyDataObject<MdErrorDeal> {
        @JsonCreator
        public MdStreamErrorDealDataPublishBody(
                @JsonProperty("dataObject") @NotNull final MdErrorDeal dataObject
        ) {
            super(dataObject);
        }
    }
}
