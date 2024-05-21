package com.example.sendemail.service;

import com.example.sendemail.model.User;
import com.example.sendemail.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WinningService {

    private final UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> filterWinningUsers(){
        return getAllUsers().stream()
                .filter(
                        user -> user.getPrize().getIsWinner().equals(Boolean.TRUE)
                )
                .toList();
    }

    public List<User> filterLoserUsers(){
        return getAllUsers().stream()
                .filter(
                        user -> user.getPrize().getIsWinner().equals(Boolean.FALSE)
                )
                .toList();
    }

}
