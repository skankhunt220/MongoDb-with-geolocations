package com.lootfood.service;

import com.lootfood.entity.LootPoint;
import com.lootfood.repository.lootpoint.LootPointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LootPointService {
    private final LootPointRepository lootpointRepository;

    public LootPoint add(LootPoint lootPoint) {
        return lootpointRepository.save(lootPoint);
    }

    public LootPoint getById(String id) {
        return lootpointRepository.findById(id).get();
    }

    public Page<LootPoint> getAll(Pageable pageable) {
        return lootpointRepository.findAll(pageable);
    }

    public Page<LootPoint> getAllInPolygon(List<List<Double>> points, Pageable pageable) {
        return lootpointRepository.findAllLootPointsInPolygon(points, pageable);
    }

    public LootPoint update(LootPoint lootPoint) {
        LootPoint lootPointFromDb = lootpointRepository.findById(lootPoint.getId()).get();
        lootPointFromDb.setName(lootPoint.getName());
        lootPointFromDb.setDescription(lootPoint.getDescription());
        lootPointFromDb.setType(lootPoint.getType());
        lootPointFromDb.setOrders(lootPoint.getOrders());
        lootPointFromDb.setLocation(lootPoint.getLocation());

        return lootpointRepository.save(lootPointFromDb);
    }

    public void delete(String id) {
        lootpointRepository.deleteById(id);
    }
}
