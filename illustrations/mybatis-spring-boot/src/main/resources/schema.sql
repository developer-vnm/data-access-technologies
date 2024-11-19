create schema if not exists illustrator;

create table IF not exists illustrator.items
(
    id                      BIGSERIAL          PRIMARY KEY,
    amount                  BIGINT             NOT NULL
);

insert into illustrator.items (id, amount)
values (1, 0)
on conflict (id) do nothing;