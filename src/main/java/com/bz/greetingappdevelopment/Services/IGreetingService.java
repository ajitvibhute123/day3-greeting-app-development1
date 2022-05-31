package com.bz.greetingappdevelopment.Services;

import com.bz.greetingappdevelopment.controller.Greeting;
import com.bz.greetingappdevelopment.dto.UserDto;

public interface IGreetingService {
    Greeting greetingMessage();

    String greetingMessageByName(UserDto userDto);
}