package com.lootfood.repository.lootpoint;

import com.lootfood.entity.LootPoint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LootPointRepositoryCustom {
    Page<LootPoint> findAllLootPointsInPolygon(List<List<Double>> points, Pageable pageable);
}
