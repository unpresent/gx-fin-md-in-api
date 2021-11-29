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

import java.time.LocalDate;
import java.util.UUID;

/**
 * Производный ФИ
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Derivative extends AbstractInstrument {
    /**
     * Базовый инструмент (на который этот дериватив)
     */
    @JsonIdentityReference(alwaysAsId = true)
    private final AbstractInstrument baseInstrument;

    @Nullable
    private final LocalDate expireDate;

    public Derivative(
            @NotNull final UUID guid,
            @NotNull final InstrumentType type,
            @Nullable final String internalShortName,
            @Nullable final String internalFullName,
            AbstractInstrument baseInstrument, @Nullable final LocalDate expireDate
    ) {
        super(guid, type, internalShortName, internalFullName);
        this.baseInstrument = baseInstrument;
        this.expireDate = expireDate;
    }
}
