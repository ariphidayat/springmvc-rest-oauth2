package org.arip.springmvc.rest.oauth2.service;

import org.arip.springmvc.rest.oauth2.model.User;
import java.util.List;

public interface UserService {

    List<User> findAll();

}
