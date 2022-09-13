package com.wust.demoproject.mapper;

import com.wust.demoproject.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> userMap= new HashMap<>();
    static{
        userMap.put("w1",new User(1,"w1","1w"));
        userMap.put("w2",new User(2,"w2","2w"));
        userMap.put("w3",new User(3,"w3","3w"));
    }

    public User login(String username,String pwd){
        User user = userMap.get(username);
        if (user == null){
            return null;
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }
        return null;
    }

    public List<User> listUser(){
        List<User> list = new ArrayList<>();
        list.addAll(userMap.values());
        return list;
    }
}
