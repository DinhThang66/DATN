package org.example.project.service.course;

import org.example.project.model.Course;
import org.example.project.model.Department;
import org.example.project.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Boolean create(Course course) {
        try{
            this.courseRepository.save(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Course findById(Long id) {
        return this.courseRepository.findById(id).get();
    }

    @Override
    public Boolean update(Course course) {
        try {
            this.courseRepository.save(course);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Boolean delete(Long id) {
        try {
            this.courseRepository.delete(findById(id));
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Course> searchCourseById(String keyword) {
        return this.courseRepository.searchCourseById(keyword);
    }

    @Override
    public List<Course> searchCourseByName(String keyword) {
        return this.courseRepository.searchCourseByName(keyword);
    }

    @Override
    public List<Course> searchCourseByDept(Long keyword) {
        return this.courseRepository.searchCourseByDept(keyword);
    }

    @Override
    public Page<Course> getAll(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo - 1, 8);
        return this.courseRepository.findAll(pageable);
    }

    @Override
    public Page<Course> getAll(String keywordId, String keywordName, Integer pageNo) {
        List<Course> list = this.searchCourse( keywordName, keywordId);

        Pageable pageable = PageRequest.of(pageNo - 1, 8);

        int start = (int) pageable.getOffset();
        int end = (int) ((pageable.getOffset()+ pageable.getPageSize()) >list.size() ? list.size() : (pageable.getOffset() + pageable.getPageSize()));

        list = list.subList(start, end);
        return new PageImpl<Course>(list, pageable, this.searchCourseByName(keywordName).size());
    }

    @Override
    public Page<Course> searchDept(Long keywordDeptId, String  keywordId, String keywordName, Integer pageNo) {
        //List<Course> list = this.searchCourseByName(keywordName);
        List<Course> list = this.searchCourse(keywordDeptId, keywordName, keywordId);

        Pageable pageable = PageRequest.of(pageNo - 1, 8);

        int start = (int) pageable.getOffset();
        int end = (int) ((pageable.getOffset()+ pageable.getPageSize()) >list.size() ? list.size() : (pageable.getOffset() + pageable.getPageSize()));

        list = list.subList(start, end);
        return new PageImpl<Course>(list, pageable, this.searchCourseByName(keywordName).size());
    }

    @Override
    public List<Course> searchCourse(Long keyword, String courseName, String courseId) {
        return this.courseRepository.searchCourse(keyword,courseName, courseId);
    }

    @Override
    public List<Course> searchCourse(String courseName, String courseId) {
        return this.courseRepository.searchCourse(courseName, courseId);
    }

    @Override
    public Integer numberOfCourses() {
        return this.courseRepository.numberOfCourses();
    }


}
