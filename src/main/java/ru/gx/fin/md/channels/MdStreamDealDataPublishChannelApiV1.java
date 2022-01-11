package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamDealDataPublish;

@SuppressWarnings("unused")
public class MdStreamDealDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamDealDataPublish> {

    public MdStreamDealDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.DEALS_V1,
                SerializeMode.JsonString,
                MdStreamDealDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.DEALS,
                MdStreamDealDataPublish.V1
        );
    }
}
