package it.corso.spb01.services;

import it.corso.spb01.model.Course;

import java.util.List;

public interface CourseService {
    public List<Course> getCourses ();
    public Course getCorseByID(Long id);
    public Course addCourse( Course c );
    public void deleteCourse ( Long id );
    public Course updateCourse( Long id, Course c ) throws  Exception;
}
