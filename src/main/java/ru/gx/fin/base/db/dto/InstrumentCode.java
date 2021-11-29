package ru.gx.fin.base.db.dto;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.data.AbstractDataObject;

import java.time.LocalDate;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = {"provider", "code"})
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentCode extends AbstractDataObject {
    /**
     * Код провайдера, который идентифицирует инструмент, которому принадлежит данная запись
     */
    @JsonIdentityReference(alwaysAsId = true)
    @NotNull
    private final Provider provider;

    /**
     * Код инструмента (идентификатор) на данном провайдере для данного инструмента
     */
    @NotNull
    private final String code;

    /**
     * Название инструмента на данном провайдере
     */
    @Nullable
    private final String name;

    /**
     * Порядковый номер кода (для случаев, когда провайдер о данном инструменте транслирует несколько кодов)
     */
    private final short index;

    /**
     * Дата, начиная с которой данный код начал действовать
     */
    @Nullable
    private final LocalDate dateFrom;

    /**
     * Дата, до (не включая) которой данный код действовал
     */
    @Nullable
    private final LocalDate dateTo;

    public InstrumentCode(
            @NotNull final Provider provider,
            @NotNull final String code,
            @Nullable final String name,
            short index,
            @Nullable final LocalDate dateFrom,
            @Nullable final LocalDate dateTo
    ) {
        this.provider = provider;
        this.code = code;
        this.name = name;
        this.index = index;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }
}
