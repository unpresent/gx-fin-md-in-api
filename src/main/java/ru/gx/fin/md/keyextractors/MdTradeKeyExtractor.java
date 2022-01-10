package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdTrade;

@SuppressWarnings("unused")
public class MdTradeKeyExtractor implements DataObjectKeyExtractor<MdTrade> {
    @Override
    public Object extractKey(@NotNull MdTrade dataObject) {
        return dataObject.getId();
    }
}
