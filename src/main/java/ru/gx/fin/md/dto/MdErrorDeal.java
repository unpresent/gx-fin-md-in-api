package ru.gx.fin.md.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.jetbrains.annotations.NotNull;
import ru.gx.core.data.AbstractDataObject;

import java.time.LocalDateTime;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdErrorDeal extends AbstractDataObject {
    /**
     * Идентификатор сделки - составной ключ = {@link #placeCode} + ":" + {@link #tradeNum}.
     */
    @NotNull
    private final String id;

    /**
     * Код биржи в торговой системе
     */
    @NotNull
    private final String placeCode;

    /**
     * Номер сделки в торговой системе
     */
    @NotNull
    private final String tradeNum;

    /**
     * Дата и время
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    @NotNull
    private final LocalDateTime tradeDateTime;

    /**
     * Информация об ошибке.
     */
    @NotNull
    private final String errorInfo;

    @JsonCreator
    public MdErrorDeal(
            @JsonProperty("placeCode") @NotNull final String placeCode,
            @JsonProperty("tradeNum") @NotNull final String tradeNum,
            @JsonProperty("tradeDateTime") @NotNull final LocalDateTime tradeDateTime,
            @JsonProperty("errorInfo") @NotNull final String errorInfo
    ) {
        super();
        this.placeCode = placeCode;
        this.tradeNum = tradeNum;
        this.tradeDateTime = tradeDateTime;
        this.errorInfo = errorInfo;
        // Устанавливаем this.id!
        this.id = calcId();
    }

    /**
     * Вычисление идентификатора сделки.
     */
    @NotNull
    protected String calcId() {
        return this.placeCode + ":" + this.tradeNum;
    }
}
