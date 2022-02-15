package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdErrorOrder;

@SuppressWarnings("unused")
public class MdErrorOrderKeyExtractor implements DataObjectKeyExtractor<MdErrorOrder> {
    @Override
    public Object extractKey(@NotNull MdErrorOrder dataObject) {
        return dataObject.getId();
    }
}
