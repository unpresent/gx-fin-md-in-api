package ru.gx.fin.base.db.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

/**
 * Валюта
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency extends AbstractInstrument {

    /**
     * Код Alpha-2
     */
    @NotNull
    private final String codeAlpha2;

    /**
     * Код Alpha-3
     */
    @NotNull
    private final String codeAlpha3;

    /**
     * Код Dec
     */
    @Nullable
    private final Short codeDec;

    /**
     * Знак
     */
    @Nullable
    private final String sign;

    /**
     * Название разменной части
     */
    @Nullable
    private final String partsNames;

    /**
     * Сколько разменных единиц в единице валюты (сколько "копеек в рубле")
     */
    @Nullable
    private final Integer partsInOne;

    public Currency(
            @NotNull final UUID guid,
            @NotNull final InstrumentType type,
            @Nullable final String internalShortName,
            @Nullable final String internalFullName,
            @NotNull final String codeAlpha2,
            @NotNull final String codeAlpha3,
            @Nullable final Short codeDec,
            @Nullable final String sign,
            @Nullable final String partsNames,
            @Nullable final Integer partsInOne
    ) {
        super(guid, type, internalShortName, internalFullName);
        this.codeAlpha2 = codeAlpha2;
        this.codeAlpha3 = codeAlpha3;
        this.codeDec = codeDec;
        this.sign = sign;
        this.partsNames = partsNames;
        this.partsInOne = partsInOne;
    }
}
