package com.example.hibernate;

import com.example.hibernate.entity.User;
import com.example.hibernate.entity.UserProfile;
import com.example.hibernate.repository.UserProfileRepository;
import com.example.hibernate.repository.UserRepository;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.provider.HibernateUtils;

import java.time.LocalDate;
import java.util.Optional;

@SpringBootApplication
public class SpringbootHibernateOneToOneMappingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHibernateOneToOneMappingApplication.class, args);

    }

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setName("anusha");
        user.setEmail("anusha@gmail.com");

        UserProfile userProfile = new UserProfile();
        userProfile.setAddress("chedimala");
        userProfile.setBirthDate(LocalDate.of(1999, 10, 27));
        userProfile.setPhoneNumber("9121345678");

        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);


    }
}
