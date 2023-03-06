package examiner.controllers;

import examiner.domain.User;
import examiner.filters.TransactionFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final static Logger LOG = LoggerFactory.getLogger(TransactionFilter.class);

//    @GetMapping("")
//    public List<User> getAllUsers(){
//        LOG.info("Fetching all the users.");
//        LOG.info("Fetching all the users");
//        return Arrays.asList(
//                new User(111L, "User1", "user1@test.com"),
//                new User(222L, "User1", "user1@test.com"),
//                new User(333L, "User1", "user1@test.com"));
//
//    }
}
