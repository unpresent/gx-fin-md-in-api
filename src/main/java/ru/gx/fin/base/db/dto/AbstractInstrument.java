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

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * ФИ
 */
@Getter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "guid")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractInstrument extends AbstractDataObject {
    @NotNull
    private final UUID guid;

    /**
     * Тип ФИ
     */
    @JsonIdentityReference(alwaysAsId = true)
    @NotNull
    private final InstrumentType type;

    /**
     * Краткое внутреннее (в наших системах) наименование ФИ
     */
    @Nullable
    private final String internalShortName;

    /**
     * Полное внутреннее (в наших системах) наименование ФИ
     */
    @Nullable
    private final String internalFullName;

    private final List<InstrumentCode> codes = new ArrayList<>();

    protected AbstractInstrument(
            @NotNull final UUID guid,
            @NotNull final InstrumentType type,
            @Nullable final String internalShortName,
            @Nullable final String internalFullName
    ) {
        super();
        this.guid = guid;
        this.type = type;
        this.internalShortName = internalShortName;
        this.internalFullName = internalFullName;
    }
}
