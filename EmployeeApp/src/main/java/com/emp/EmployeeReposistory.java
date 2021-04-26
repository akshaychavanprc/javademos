package com.emp;
import org.springframework.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeReposistory  extends JpaRepository<EmployeeEntity,Long>{

}
