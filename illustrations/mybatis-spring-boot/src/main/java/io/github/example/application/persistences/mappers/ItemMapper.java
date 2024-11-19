package io.github.example.application.persistences.mappers;

import io.github.example.application.models.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Mapper
public interface ItemMapper {

    @Select("SELECT * FROM items WHERE id = #{id}")
    Optional<Item> findById(@Param("id") Long id);

    @Insert("UPDATE items SET amount = #{amount} WHERE id = #{id}")
    void updateAmount(@Param("id") Long id, @Param("amount") Long amount);
}