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
 * Тип провайдера
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "code")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderType extends AbstractDataObject {
    /**
     * Родительсткий тип самого верхнего уровня
     */
    @JsonIdentityReference(alwaysAsId = true)
    @Nullable
    private final ProviderType rootType;

    /**
     * Родительсткий тип провайдера
     */
    @JsonIdentityReference(alwaysAsId = true)
    @Nullable
    private final ProviderType parent;

    /**
     * Код типа провайдера
     */
    @NotNull
    private final String code;

    /**
     * Название типа провайдера
     */
    @Nullable
    private final String name;

    public ProviderType(
            @Nullable final ProviderType rootType,
            @Nullable final ProviderType parent,
            @NotNull final String code,
            @Nullable final String name
    ) {
        this.rootType = rootType;
        this.parent = parent;
        this.code = code;
        this.name = name;
    }
}
