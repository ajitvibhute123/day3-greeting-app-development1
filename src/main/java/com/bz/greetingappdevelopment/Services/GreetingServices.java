package com.bz.greetingappdevelopment.Services;

import com.bz.greetingappdevelopment.controller.Greeting;
import com.bz.greetingappdevelopment.dto.User;
import com.bz.greetingappdevelopment.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServices implements IGreetingService {
    private static final String template = "Hello world";
    private final AtomicLong counter = new AtomicLong();


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

}