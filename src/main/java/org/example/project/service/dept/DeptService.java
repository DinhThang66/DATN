package org.example.project.service.dept;

import org.example.project.model.Department;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeptService {
    List<Department> getAll();
    Boolean create(Department department);
    Department findById(Long id);
    Boolean update(Department department);
    Boolean delete(Long id);
    List<Department> searchDept(String keyword);
    Page<Department> getAll(Integer pageNo);
}
