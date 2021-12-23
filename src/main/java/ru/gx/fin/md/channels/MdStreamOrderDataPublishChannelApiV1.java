package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamOrderDataPublish;

@SuppressWarnings("unused")
public class MdStreamOrderDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamOrderDataPublish> {

    public MdStreamOrderDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.ORDERS_V1,
                SerializeMode.JsonString,
                MdStreamOrderDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.ORDERS,
                MdStreamOrderDataPublish.V1
        );
    }
}
