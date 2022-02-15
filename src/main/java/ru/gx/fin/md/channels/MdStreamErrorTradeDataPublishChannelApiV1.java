package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamErrorTradeDataPublish;

@SuppressWarnings("unused")
public class MdStreamErrorTradeDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamErrorTradeDataPublish> {

    public MdStreamErrorTradeDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.ERROR_TRADES_V1,
                SerializeMode.JsonString,
                MdStreamErrorTradeDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.ERROR_TRADES,
                MdStreamErrorTradeDataPublish.V1
        );
    }
}
