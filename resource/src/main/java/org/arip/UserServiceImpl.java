package org.arip;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("10", "Lionel Messi", "Barelona FC", "messi@barcelonafc.com", "Spain"));
        return userList;
    }
}