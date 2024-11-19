package io.github.example.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {

    private Long id;

    private Long amount;

    public void addAmount(final Long amount) {
        Assert.notNull(amount, "amount cannot be null");
        Assert.isTrue(0 < amount, "amount cannot be zero or negative");
        this.amount += amount;
    }
}