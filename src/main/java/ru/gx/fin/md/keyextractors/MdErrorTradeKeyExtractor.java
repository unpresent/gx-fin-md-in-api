package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdErrorTrade;

@SuppressWarnings("unused")
public class MdErrorTradeKeyExtractor implements DataObjectKeyExtractor<MdErrorTrade> {
    @Override
    public Object extractKey(@NotNull MdErrorTrade dataObject) {
        return dataObject.getId();
    }
}
