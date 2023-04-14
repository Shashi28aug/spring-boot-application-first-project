package com.example.demo.project1database.course;

import com.example.demo.project1database.topic.TopicRepository;
import com.example.demo.project1database.topic.Topics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCoures(String topicId){
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(course -> {
            if(course.getTopics().getId().equals(topicId))
                courses.add(course);
        });
        return courses;
    }

    public Course getCourseById(String id, String topicId){
        return courseRepository.findById(id).filter(course -> course.getTopics().getId().equals(topicId)).get();
    }

    public void addCourse(Course course, String topicId){
        course.setTopics(new Topics(topicId, "", ""));
        courseRepository.save(course);
    }

    public void updateCourseById(String id, Course course, String topicId){
        course.setTopics(new Topics(topicId, "", ""));
        courseRepository.save(course);
    }

    public void deleteCourseById(String id, String topicId){
        courseRepository.deleteById(id);
    }

}
