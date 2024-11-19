package io.github.example.application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.util.Assert;

@Entity
@Table(name = "items")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private Long id;

    @Column
    private Long amount;

    public void addAmount(final Long amount) {
        Assert.notNull(amount, "amount cannot be null");
        Assert.isTrue(0 < amount, "amount cannot be zero or negative");
        this.amount += amount;
    }
}