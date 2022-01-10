package ru.gx.fin.md.dto;

import lombok.ToString;
import ru.gx.core.data.AbstractDataPackage;
import ru.gx.fin.common.fics.out.AbstractInstrument;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public abstract class MdDealsPackage<O extends MdDeal> extends AbstractDataPackage<O> {
}
