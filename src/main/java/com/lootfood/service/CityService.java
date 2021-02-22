package com.lootfood.service;

import com.lootfood.entity.City;
import com.lootfood.repository.city.CityRepository;
import com.mongodb.client.model.geojson.Point;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public City add(City city) {
        return cityRepository.save(city);
    }

    public City getById(String id) {
        return cityRepository.findById(id).get();
    }

    public City getByLocation(Point point) {
        return cityRepository.findCityByGeoIntersects(point);
    }

    public Page<City> getAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    public City update(City city) {
        City cityFromDb = cityRepository.findById(city.getId()).get();
        cityFromDb.setName(city.getName());
        cityFromDb.setLocation(city.getLocation());

        return cityRepository.save(cityFromDb);
    }

    public void delete(String id) {
        cityRepository.deleteById(id);
    }
}