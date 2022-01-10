package ru.gx.fin.md.keyextractors;

import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.DataObjectKeyExtractor;
import ru.gx.fin.md.dto.MdDeal;

@SuppressWarnings("unused")
public class MdDealKeyExtractor implements DataObjectKeyExtractor<MdDeal> {
    @Override
    public Object extractKey(@NotNull MdDeal dataObject) {
        return dataObject.getId();
    }
}
