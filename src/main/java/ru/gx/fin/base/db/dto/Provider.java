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

/**
 * Провайдеры
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true, of = "code")
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provider extends AbstractDataObject {
    /**
     * Код
     */
    @NotNull
    private final String code;

    /**
     * Название.
     */
    @Nullable
    private final String name;

    /**
     * Тип провайдера
     */
    @JsonIdentityReference(alwaysAsId = true)
    @NotNull
    private final ProviderType type;

    /**
     * Площадка, о которой танслирует данный провайдер
     */
    @JsonIdentityReference(alwaysAsId = true)
    @Nullable
    private final Place place;

    public Provider(
            @NotNull final String code,
            @Nullable final String name,
            @NotNull final ProviderType type,
            @Nullable final Place place
    ) {
        this.code = code;
        this.name = name;
        this.type = type;
        this.place = place;
    }
}
