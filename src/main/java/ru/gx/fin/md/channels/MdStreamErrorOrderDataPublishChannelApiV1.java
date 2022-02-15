package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamErrorOrderDataPublish;

@SuppressWarnings("unused")
public class MdStreamErrorOrderDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamErrorOrderDataPublish> {

    public MdStreamErrorOrderDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.ERROR_ORDERS_V1,
                SerializeMode.JsonString,
                MdStreamErrorOrderDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.ERROR_ORDERS,
                MdStreamErrorOrderDataPublish.V1
        );
    }
}
