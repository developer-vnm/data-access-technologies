package io.github.example.application.services.impl;

import io.github.example.application.persistences.mappers.ItemMapper;
import io.github.example.application.services.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;

    @Transactional
    @Override
    public void increaseAmount(final Long id, final Long amount) {
        var item = itemMapper.findById(id)
                .orElseThrow();
        item.addAmount(amount);
        itemMapper.updateAmount(id, item.getAmount());
        var updatedItem = itemMapper.findById(id)
                .orElseThrow();
        log.info("current amount updated_amount={} of id id={}", updatedItem.getAmount(), id);
    }
}