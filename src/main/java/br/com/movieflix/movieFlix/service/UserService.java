package br.com.movieflix.movieFlix.service;

import br.com.movieflix.movieFlix.dto.UserDTO;
import br.com.movieflix.movieFlix.mapper.UserMapper;
import br.com.movieflix.movieFlix.model.UserModel;
import br.com.movieflix.movieFlix.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO save(UserDTO userDTO) {
        UserModel userModel = userMapper.map(userDTO);
        userModel  = userRepository.save(userModel);
        return userMapper.map(userModel);
    }
}
