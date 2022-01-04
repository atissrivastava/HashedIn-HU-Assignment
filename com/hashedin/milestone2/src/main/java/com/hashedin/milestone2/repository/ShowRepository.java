package com.hashedin.milestone2.repository;

import com.hashedin.milestone2.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface ShowRepository extends JpaRepository<Show, String> {

}
