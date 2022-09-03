package com.example.todo.service.serviceImpl;

import com.example.todo.dto.UserSignupDto;
import com.example.todo.exceptions.UserAlreadyExists;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final HttpSession httpSession;

    public UserServiceImpl(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }


    @Override
    public User signup(UserSignupDto userSignupDto) {
        if(userRepository.existsByEmail(userSignupDto.getEmail())){
            throw new UserAlreadyExists("User with  " + userSignupDto.getEmail() + " already exists");
        }
        else{
            User user1 = new User();
            BeanUtils.copyProperties(userSignupDto, user1);
            return userRepository.save(user1);
        }
    }

    @Override
    public User login(UserSignupDto userSignupDto) {
        String email = userSignupDto.getEmail();


        User user = userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User not found"));
        if(!user.getPassword().equals(userSignupDto.getPassword())) {
            throw new UserNotFoundException("email or password not correct");
        }

        httpSession.setAttribute("id_exists", user.getId());
        httpSession.setAttribute("permission", "user");
        return user;
    }

    @Override
    public User fetchUsers(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        }
        else{
            throw new UserNotFoundException("user with id " + id + " not found");
        }
    }

    @Override
    public String logout() {
        httpSession.invalidate();
        return "Logged out";
    }
}
