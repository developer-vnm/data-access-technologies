package io.github.example.application.services.impl;

import io.github.example.application.entities.Item;
import io.github.example.application.services.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemServiceV3Impl implements ItemService {

    private final SessionFactory sessionFactory;

    @Override
    public void increaseAmount(final Long id, final Long amount) {

        Transaction transaction = null;

        try (var session = sessionFactory.openSession()) {

            transaction = session.beginTransaction();

            var item = Optional.ofNullable(session.find(Item.class, id))
                    .orElseThrow();
            item.addAmount(amount);
            session.merge(item);

            transaction.commit();

            log.info("current amount updated_amount={} of id id={}", item.getAmount(), id);
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}