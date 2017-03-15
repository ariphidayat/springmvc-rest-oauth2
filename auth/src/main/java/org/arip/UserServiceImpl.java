package org.arip;

import org.arip.User;
import org.arip.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    public List<User> findAll() {
        List<User> userList = new ArrayList<User>();
        userList.add(new User("10108665", "Arip Hidayat", "arip", "ariphidayat@hotmail.com", "Karet Karya 1 Setiabudi"));
        userList.add(new User("10108674", "Alisiana Ulfah", "alisiana", "ulfah.alisiana@gmail.com", "Petojo Sabangan"));
        return userList;
    }
}
