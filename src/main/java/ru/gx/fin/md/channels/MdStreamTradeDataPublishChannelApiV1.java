package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamTradeDataPublish;

@SuppressWarnings("unused")
public class MdStreamTradeDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamTradeDataPublish> {

    public MdStreamTradeDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.TRADES_V1,
                SerializeMode.JsonString,
                MdStreamTradeDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.TRADES,
                MdStreamTradeDataPublish.V1
        );
    }
}
