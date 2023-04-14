package com.example.demo.project1database.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCoures(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourseById(@PathVariable String id, @PathVariable String topicId){
        return courseService.getCourseById(id, topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        courseService.addCourse(course, topicId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
    public void updateCourseById(@PathVariable String id, @RequestBody Course course, @PathVariable String topicId){
        courseService.updateCourseById(id, course, topicId);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
    public void deleteCourseById(@PathVariable String id, @PathVariable String topicId){
        courseService.deleteCourseById(id, topicId);
    }


}
