package io.github.example.application.services.impl;

import io.github.example.application.repositories.ItemRepository;
import io.github.example.application.services.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceV1Impl implements ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    @Override
    public void increaseAmount(final Long id, final Long amount) {
        var item = itemRepository.findById(id)
                .orElseThrow();
        item.addAmount(amount);
        var updatedItem = itemRepository.save(item);
        log.info("current amount updated_amount={} of id id={}", updatedItem.getAmount(), id);
    }
}