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

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Security extends AbstractInstrument {

    /**
     * Код ISIN
     */
    @Nullable
    private final String codeIsin;

    public Security(
            @NotNull final UUID guid,
            @NotNull final InstrumentType type,
            @Nullable final String internalShortName,
            @Nullable final String internalFullName,
            @Nullable String codeIsin
    ) {
        super(guid, type, internalShortName, internalFullName);
        this.codeIsin = codeIsin;
    }
}
