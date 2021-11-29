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
 * Тип ФИ
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "code")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class InstrumentType extends AbstractDataObject {
    /**
     * Родительсткий тип самого верхнего уровня
     */
    @JsonIdentityReference(alwaysAsId = true)
    @Nullable
    private final InstrumentType rootType;

    /**
     * Родительсткий тип ФИ
     */
    @JsonIdentityReference(alwaysAsId = true)
    @Nullable
    private final InstrumentType parent;

    /**
     * Код ФИ
     */
    @NotNull
    private final String code;

    /**
     * Краткое название типа ФИ
     */
    @Nullable
    private final String nameShort;

    /**
     * Полное название типа ФИ
     */
    @Nullable
    private final String nameFull;

    public InstrumentType(
            @Nullable final InstrumentType rootType,
            @Nullable final InstrumentType parent,
            @NotNull final String code,
            @Nullable final String nameShort,
            @Nullable final String nameFull
    ) {
        this.rootType = rootType;
        this.parent = parent;
        this.code = code;
        this.nameShort = nameShort;
        this.nameFull = nameFull;
    }
}
