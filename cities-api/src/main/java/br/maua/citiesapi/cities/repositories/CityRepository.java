package br.maua.citiesapi.cities.repositories;

import br.maua.citiesapi.cities.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
