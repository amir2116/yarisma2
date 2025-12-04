package com.example.yarisma.repository;

import com.example.yarisma.model.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {


    public Optional<Team> findById(long id);
}
