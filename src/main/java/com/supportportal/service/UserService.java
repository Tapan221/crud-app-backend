package com.supportportal.service;

import com.supportportal.domain.User;
import com.supportportal.exception.domain.EmailExistException;
import com.supportportal.exception.domain.UserNotFoundException;
import com.supportportal.exception.domain.UsernameExistException;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

    User register(String firstName, String lastName, String username, String email) throws UserNotFoundException, UsernameExistException, EmailExistException;

    List<User> getUsers();

    User findUserByUsername(String username);

    User findUserByEmail(String email);
    
    
//    User addNewUser(String firstName, String lastName, String userName, String email,String role,boolean isNotLocked, boolean isActive);
//    User updateUser(String newFirstName, String newLastName, String newUserName, String newEmail,String role,boolean isNotLocked, boolean isActive);
//    void deleteUser(long id);
//    void resetPassword(String password);
//    User updateProfileImage(String username,MultipartFile profileImage);
}
