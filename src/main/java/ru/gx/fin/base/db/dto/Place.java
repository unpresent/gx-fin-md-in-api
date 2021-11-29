package ru.gx.fin.base.db.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.gx.core.data.AbstractDataObject;

@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "code")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Place extends AbstractDataObject {
    /**
     * Код.
     */
    @NotNull
    private final String code;

    /**
     * Название.
     */
    @Nullable
    private final String name;

    public Place(
            @NotNull final String code,
            @Nullable final String name
    ) {
        this.code = code;
        this.name = name;
    }
}
