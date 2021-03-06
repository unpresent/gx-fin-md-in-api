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
import org.jetbrains.annotations.Nullable;
import ru.gx.core.data.AbstractDataObject;
import ru.gx.fin.common.dris.out.DealDirection;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Обезличенная сделка
 */
@Getter
@Setter
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true, of = "id")
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class MdDeal extends AbstractDataObject {
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
     * Поручение в торговой системе
     */
    @NotNull
    private final String orderNum;

    /**
     * Направление сделки (Покупка / Продажа)
     */
    @Nullable
    private final DealDirection direction;

    /**
     * Дата и время
     */
    @JsonFormat(pattern = "yyy-MM-dd HH:mm:ss.SSS")
    @NotNull
    private final LocalDateTime tradeDateTime;

    /**
     * ФИ, с которым совершена сделка
     */
    @NotNull
    private final UUID instrumentGuid;

    /**
     * Валюта, в которой совершена сделка
     */
    @NotNull
    private final String currencyCodeAlpha3;

    /**
     * Цена
     */
    @Nullable
    private final BigDecimal price;

    /**
     * Количество ФИ в последней сделке в штуках
     */
    @Nullable
    private final BigDecimal quantity;

    /**
     * Объем в денежных средствах
     */
    @Nullable
    private final BigDecimal value;

    /**
     * Накопленный купонный доход
     */
    @Nullable
    private final BigDecimal accruedInterest;

    /**
     * Доходность
     */
    @Nullable
    private final BigDecimal yield;

    /**
     * Ставка РЕПО (%)
     */
    @Nullable
    private final BigDecimal repoRate;

    /**
     * Сумма РЕПО
     */
    @Nullable
    private final BigDecimal repoValue;

    /**
     * Объем выкупа РЕПО
     */
    @Nullable
    private final BigDecimal repo2Value;

    /**
     * Срок РЕПО в днях
     */
    private final int repoTerm;

    /**
     * Период торговой сессии. Возможные значения:
     * «0» – Открытие;
     * «1» – Нормальный;
     * «2» – Закрытие
     */
    private final short period;

    @JsonCreator
    public MdDeal(
            @JsonProperty("placeCode") @NotNull final String placeCode,
            @JsonProperty("tradeNum") @NotNull final String tradeNum,
            @JsonProperty("orderNum") @NotNull final String orderNum,
            @JsonProperty("direction") @Nullable final DealDirection direction,
            @JsonProperty("tradeDateTime") @NotNull final LocalDateTime tradeDateTime,
            @JsonProperty("instrumentGuid") @NotNull final UUID instrumentGuid,
            @JsonProperty("currencyCodeAlpha3") @NotNull final String currencyCodeAlpha3,
            @JsonProperty("price") @Nullable final BigDecimal price,
            @JsonProperty("quantity") @Nullable final BigDecimal quantity,
            @JsonProperty("value") @Nullable final BigDecimal value,
            @JsonProperty("accruedInterest") @Nullable final BigDecimal accruedInterest,
            @JsonProperty("yield") @Nullable final BigDecimal yield,
            @JsonProperty("repoRate") @Nullable final BigDecimal repoRate,
            @JsonProperty("repoValue") @Nullable final BigDecimal repoValue,
            @JsonProperty("repo2Value") @Nullable final BigDecimal repo2Value,
            @JsonProperty("repoTerm") final int repoTerm,
            @JsonProperty("period") final short period
    ) {
        super();
        this.placeCode = placeCode;
        this.tradeNum = tradeNum;
        this.orderNum = orderNum;
        this.direction = direction;
        this.tradeDateTime = tradeDateTime;
        this.instrumentGuid = instrumentGuid;
        this.currencyCodeAlpha3 = currencyCodeAlpha3;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
        this.accruedInterest = accruedInterest;
        this.yield = yield;
        this.repoRate = repoRate;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.period = period;
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
