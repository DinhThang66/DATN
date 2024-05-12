package org.example.project.repositories;

import org.example.project.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DeptRepository extends JpaRepository<Department, Long> {
    @Query("select d from Department d where d.name like %?1% or d.dept_id like %?1%")
    List<Department> searchDept(String keyword);

}
