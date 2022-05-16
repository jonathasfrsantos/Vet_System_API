package com.jonathasdeveloper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathasdeveloper.entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {


}
