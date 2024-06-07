package org.example.project.service.dept;

import org.example.project.model.Department;
import org.example.project.repositories.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService{
    @Autowired
    private DeptRepository deptRepository;


    @Override
    public List<Department> getAll() {
            return this.deptRepository.findAll();
    }

    @Override
    public Boolean create(Department department) {
        try {
            this.deptRepository.save(department);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Department findById(Long id) {
        return this.deptRepository.findById(id).get();
    }

    @Override
    public Boolean update(Department department) {
        try {
            this.deptRepository.save(department);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.deptRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Department> searchDept(String keyword) {
        return this.deptRepository.searchDept(keyword);
    }

    @Override
    public Page<Department> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 5);
        return this.deptRepository.findAll(pageable);
    }

    @Override
    public Page<Department> searchDept(String keyword, Integer pageNo) {
        List<Department> list = this.searchDept(keyword);
        Pageable pageable = PageRequest.of(pageNo - 1, 5);

        int start = (int) pageable.getOffset();
        int end = (int) ((pageable.getOffset()+ pageable.getPageSize()) >list.size() ? list.size() : (pageable.getOffset() + pageable.getPageSize()));

        list = list.subList(start, end);
        return new PageImpl<Department>(list, pageable, this.searchDept(keyword).size());
    }
}
