package ru.gx.fin.md.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.AbstractDataObject;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdErrorOrder extends AbstractDataObject {
    /**
     * Идентификатор сделки - составной ключ = {@link #placeCode} + ":" + {@link #orderNum}.
     */
    @NotNull
    private final String id;

    /**
     * Код биржи в торговой системе
     */
    @NotNull
    private final String placeCode;

    /**
     * Номер заявки в торговой системе
     */
    @NotNull
    private final String orderNum;

    /**
     * Информация об ошибке.
     */
    @NotNull
    private final String errorInfo;

    @JsonCreator
    public MdErrorOrder(
            @JsonProperty("placeCode") @NotNull final String placeCode,
            @JsonProperty("orderNum") @NotNull final String orderNum,
            @JsonProperty("errorInfo") @NotNull final String errorInfo
    ) {
        super();
        this.placeCode = placeCode;
        this.orderNum = orderNum;
        this.errorInfo = errorInfo;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора сделки.
     */
    @NotNull
    protected String calcId() {
        return this.placeCode + ":" + this.orderNum;
    }
}
