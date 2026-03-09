package com.thongfazon.account.domain.valueobject;

import com.thong.common.domain.exception.DomainException;

import java.math.BigDecimal;

public record Money(BigDecimal amount, Currency currency)
 {

    public static Money of(BigDecimal amount, Currency currency) {
        return new Money(amount, currency);
    }

    public Money add(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot add money with different currencies");
        }
        return new Money(this.amount.add(other.amount), this.currency);
    }

    public Money subtract(Money other) {
        if (!this.currency.equals(other.currency)) {
            throw new IllegalArgumentException("Cannot subtract money with different currencies");
        }
        return new Money(this.amount.subtract(other.amount), this.currency);
    }

    public boolean isGreaterThan(Money otherAmount) {
        checkSameCurrency(otherAmount.currency);
        return this.amount.compareTo(otherAmount.amount) > 0;
    }

    public boolean isLessThan(Money otherAmount) {
        checkSameCurrency(otherAmount.currency);
        return this.amount.compareTo(otherAmount.amount) < 0;
    }


     public boolean isGreaterThanOrEqual(Money otherAmount) {
         checkSameCurrency(otherAmount.currency);
         return this.amount.compareTo(otherAmount.amount) >= 0;
     }

     public boolean isLessThanOrEqual(Money otherAmount) {
         checkSameCurrency(otherAmount.currency);
         return this.amount.compareTo(otherAmount.amount) <= 0;
     }

    public  void checkSameCurrency(Currency otherCurrency) {
       if ((this.currency != otherCurrency)) {
           throw new DomainException("Currency does not match");
       }
    }
}
