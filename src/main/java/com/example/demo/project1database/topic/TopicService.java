package com.example.demo.project1database.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topics> getTopics(){
        List<Topics> topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Topics getTopicById(String id){
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topics topic){
        topicRepository.save(topic);
    }

    public void updateTopicById(String id, Topics topic){
        topicRepository.save(topic);
    }

    public void deleteTopicById(String id){
        topicRepository.deleteById(id);
    }

}
