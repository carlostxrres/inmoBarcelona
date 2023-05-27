package com.ironhack.inmoBarcelona;

import com.ironhack.inmoBarcelona.models.User;
import com.ironhack.inmoBarcelona.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    /**
     * No need to set up data before each test, since a preliminary database is already built in
     * inmoBarcelonaApplication. There are 14 users in the database: mgarcia, cmartinez, jlopez, jhernandez, msanchez,
     * msalva, cgomez, itorres, mruiz, mferret, lydill, ugeren, ernran, euleor.
     */

    /*
    @BeforeEach
    public void setUp() {
        User user1 = new User("Maria Garcia", "mgarcia", "1234", new ArrayList<>(), new HashSet<>());
        User user2 = new User("Carlos Martínez", "cmartinez", "1234", new ArrayList<>(), new HashSet<>());
        User user3 = new User("Josep Lopez", "jlopez", "1234", new ArrayList<>(), new HashSet<>());
        User user4 = new User("Jordi Hernandez", "jhernandez", "1234", new ArrayList<>(), new HashSet<>());
        User user5 = new User("Mercedes Sanchez", "msanchez", "1234", new ArrayList<>(), new HashSet<>());

        userRepository.save(user1);
        userRepository.saveAll(List.of(user2, user3, user4, user5));
    }

    @AfterEach
    public void teardown() {
        userRepository.deleteAll();
    }
    */
    @Test
    public void shouldAddUser() {
        // Check that the 14 users in the database are the expected ones
        Iterable<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user.getUsername());
        }

        // Perform the actual test
        assertEquals(14, userRepository.findAll().size());
    }

    @Test
    public void shouldFindByUsernameInModel() {
        User user = userRepository.findAll().get(0);
        assertEquals("mgarcia", user.getUsername());
    }

    @Test
    public void shouldFindByUsernameInRepository() {
        assertEquals("Josep Lopez", userRepository.findByUsername("jlopez").getName());
    }
}
