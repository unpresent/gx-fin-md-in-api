package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdErrorDeal;

@SuppressWarnings("unused")
public class MdErrorDealKeyExtractor implements DataObjectKeyExtractor<MdErrorDeal> {
    @Override
    public Object extractKey(@NotNull MdErrorDeal dataObject) {
        return dataObject.getId();
    }
}
