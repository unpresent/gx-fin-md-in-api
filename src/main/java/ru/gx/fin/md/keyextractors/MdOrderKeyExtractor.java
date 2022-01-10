package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdOrder;

@SuppressWarnings("unused")
public class MdOrderKeyExtractor implements DataObjectKeyExtractor<MdOrder> {
    @Override
    public Object extractKey(@NotNull MdOrder dataObject) {
        return dataObject.getId();
    }
}
