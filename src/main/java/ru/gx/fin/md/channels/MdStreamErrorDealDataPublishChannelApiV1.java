package ru.gx.fin.md.channels;

import ru.gx.core.channels.AbstractChannelApiDescriptor;
import ru.gx.core.channels.SerializeMode;
import ru.gx.core.messaging.MessageKind;
import ru.gx.fin.md.config.MdChannelNames;
import ru.gx.fin.md.config.MdMessageTypes;
import ru.gx.fin.md.messages.MdStreamErrorDealDataPublish;

@SuppressWarnings("unused")
public class MdStreamErrorDealDataPublishChannelApiV1
        extends AbstractChannelApiDescriptor<MdStreamErrorDealDataPublish> {

    public MdStreamErrorDealDataPublishChannelApiV1() {
        super(
                MdChannelNames.Streams.ERROR_DEALS_V1,
                SerializeMode.JsonString,
                MdStreamErrorDealDataPublish.class,
                MessageKind.DataPublish,
                MdMessageTypes.Streams.ERROR_DEALS,
                MdStreamErrorDealDataPublish.V1
        );
    }
}
