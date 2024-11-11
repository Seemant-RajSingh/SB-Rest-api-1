package com.srs.REST.API.repositories;

import com.srs.REST.API.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// JpaRepository extends ListCrudRepository ... this writes the SQL for us .. so we only handle java
// JpaRepo<which entity to hande, its id type)
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
//    @Query("") - to write custom queries
}
