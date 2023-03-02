package com.example.onetoone;

import com.example.onetoone.model.Gender;
import com.example.onetoone.model.User;
import com.example.onetoone.model.UserProfile;
import com.example.onetoone.repository.UserProfileRepository;
import com.example.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class OneToOneApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(OneToOneApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Override
    public void run(String... args) throws Exception {

        UserProfile userProfile = UserProfile.builder()
                .phoneNumber("23434")
                .address("address")
                .gender(Gender.MALE)
                .dateOfBirth(LocalDate.of(1987, 01, 02))
                .build();

        User user = User.builder()
                .name("Spencer")
                .email("spenny@gmail.com")
                .userProfile(userProfile)
                .build();

        userProfile.setUser(user);

        userRepository.save(user);
    }
}
