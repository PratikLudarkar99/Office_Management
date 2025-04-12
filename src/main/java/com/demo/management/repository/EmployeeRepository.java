package com.demo.management.repository;

import com.demo.management.model.Designation;
import com.demo.management.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDesignation(Designation designation);

    @Query("SELECT e FROM Employee e WHERE e.salary.amount BETWEEN :minSalary AND :maxSalary")
    List<Employee> findBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

    List<Employee> findByDepartmentDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE (:designation IS NULL OR e.designation = :designation) " +
            "AND (:minSalary IS NULL OR e.salary.amount >= :minSalary) " +
            "AND (:maxSalary IS NULL OR e.salary.amount <= :maxSalary)")
    Page<Employee> findByCriteria(@Param("designation") Designation designation,
                                  @Param("minSalary") Double minSalary,
                                  @Param("maxSalary") Double maxSalary,
                                  Pageable pageable);
}
