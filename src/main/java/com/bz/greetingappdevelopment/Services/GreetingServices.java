package com.bz.greetingappdevelopment.Services;

import com.bz.greetingappdevelopment.controller.Greeting;
import com.bz.greetingappdevelopment.dto.User;
import com.bz.greetingappdevelopment.dto.UserDto;
import com.bz.greetingappdevelopment.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServices implements IGreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository iGreetingRepository;

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }
    @Override
    public User getById(long id) {
        Optional<User> greetById = iGreetingRepository.findById(id);
        return greetById.orElse(null);
    }
}