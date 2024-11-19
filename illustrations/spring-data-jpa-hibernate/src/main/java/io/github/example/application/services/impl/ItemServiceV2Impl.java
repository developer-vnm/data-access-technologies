package io.github.example.application.services.impl;

import io.github.example.application.entities.Item;
import io.github.example.application.services.ItemService;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceV2Impl implements ItemService {

    private final EntityManager entityManager;

    @Transactional
    @Override
    public void increaseAmount(final Long id, final Long amount) {
        var item = Optional.ofNullable(entityManager.find(Item.class, id))
                .orElseThrow();
        item.addAmount(amount);
        var updatedItem = entityManager.merge(item);
        log.info("current amount updated_amount={} of id id={}", updatedItem.getAmount(), id);
    }
}