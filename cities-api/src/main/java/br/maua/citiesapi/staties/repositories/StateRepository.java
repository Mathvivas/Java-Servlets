package br.maua.citiesapi.staties.repositories;

import br.maua.citiesapi.staties.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
