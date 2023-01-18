package it.corso.spb01.services.impl;

import it.corso.spb01.model.Course;
import it.corso.spb01.repository.CourseRepository;
import it.corso.spb01.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    CourseRepository courseRepository;


    public List<Course> getCourses (){
        List<Course> studentArrayList = new ArrayList<Course>();
        courseRepository.findAll().forEach(studentArrayList::add);
        return studentArrayList;
    }

    public Course getCorseByID(Long id){
            Course curr = courseRepository.findById(id).orElse(null);
            return curr;
    }

    public Course addCourse( Course c ){
        Course curr = courseRepository.save(c);
        return curr;
    }

    public void deleteCourse ( Long id ) throws RuntimeException {
            courseRepository.deleteById(id);
    }

    public Course updateCourse( Long id, Course c ) throws  Exception {
        //Course currCourse = courseRepository.findById(id).orElseThrow(() -> new Exception("TagId " + id + "not found"));
        Course currCourse = courseRepository.findById(id).orElseThrow(() -> new Exception("TagId " + id + "not found"));
        currCourse.setName(c.getName());
        courseRepository.save(currCourse);
        return currCourse;
    }


    public void uploadFile(Long id, MultipartFile data) throws IOException {
        Course _course = courseRepository.getReferenceById(id);
        _course.setData(data.getBytes());
        _course.setType(data.getContentType());
        courseRepository.save(_course);
    }


    public void deleteFile(Long id) {
        Course _course = courseRepository.getReferenceById(id);
        _course.setData(null);
        _course.setType(null);
        courseRepository.save(_course);
        return;
    }

}
