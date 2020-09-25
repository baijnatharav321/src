package com.nsahoo.repository;

import com.nsahoo.entity.ItemPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPriceRepository extends JpaRepository<ItemPriceEntity,String> {
}
