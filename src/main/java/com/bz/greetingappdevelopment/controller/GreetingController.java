package com.bz.greetingappdevelopment.controller;

import com.bz.greetingappdevelopment.Services.IGreetingService;
import com.bz.greetingappdevelopment.dto.User;
import com.bz.greetingappdevelopment.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
     *curl localhost:8080/greeting
     @return={id =1 , content="hello world!}
     * curllocalhost:8080/greeting?name=Nikita
     * @return= { id=2, content="hello Nikita!
     */
    @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    /*
    *curl localhost:8080/greeting/Nikita
    @return={id =1 , content="hello Nikita!}
     */
    @GetMapping("greeting/{name}")
    public Greeting greetings(@PathVariable String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private IGreetingService greetingService;

    /*
       *curl localhost:8080/greeting/service
       @return={id =1 , content="hello world!}
        */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();

    }

    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }

    @GetMapping("/find")
    public User findGreetById(@RequestParam long id) {
        return greetingService.getById(id);
    }

    @GetMapping("/allgreetings")
    public List<User> findAllGreeting() {
        return greetingService.getAllGreetingMessages();
    }

    @PutMapping("/editmessage/{id}")
    public User editGreetMesage(@PathVariable long id, @RequestBody UserDto userDto) {
        return greetingService.updateGreetMessage(id, userDto);

    }

    @DeleteMapping("/deletemessage/{id}")
    public String deleteGreetMessage(@PathVariable long id) {
        return greetingService.deleteGreetMessage(id);
    }

}