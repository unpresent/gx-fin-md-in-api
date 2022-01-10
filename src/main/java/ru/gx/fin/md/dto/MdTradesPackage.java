package ru.gx.fin.md.dto;

import lombok.ToString;
import ru.gx.core.data.AbstractDataPackage;

@SuppressWarnings("unused")
@ToString(callSuper = true)
public abstract class MdTradesPackage<O extends MdTrade> extends AbstractDataPackage<O> {
}
