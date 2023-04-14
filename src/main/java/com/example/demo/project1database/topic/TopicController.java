package com.example.demo.project1database.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topics> getAllTopics(){
        return topicService.getTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topics getTopicById(@PathVariable String id){
        return topicService.getTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topics topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopicById(@PathVariable String id, @RequestBody Topics topic){
        topicService.updateTopicById(id, topic);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopicById(@PathVariable String id){
        topicService.deleteTopicById(id);
    }


}
