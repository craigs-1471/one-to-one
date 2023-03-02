package com.example.onetoone.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_profiles")
@Builder
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_profile_id")
    private Long id;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Column(name = "DOB")
    private LocalDate dateOfBirth;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userProfile")
    private User user;

    public UserProfile(String phoneNumber, String address, Gender gender, LocalDate dateOfBirth) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }
}
