package com.ramji_mourya.empire.user_license_notifier.admin.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

@Valid
@Entity
@Getter
@Setter
@Table(name = "admin_details")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @NaturalId(mutable=true)
    @Column(name = "user_name")
    private String user_name;

    @NotNull
    @Email
    @NaturalId(mutable=true)
    @Column(name = "email")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "The password must:\n" +
            "- Contain at least one digit (0-9).\n" +
            "- Contain at least one lowercase letter (a-z).\n" +
            "- Contain at least one uppercase letter (A-Z).\n" +
            "- Contain at least one special character from the set: @#$%^&-+=().\n" +
            "- Be between 8 and 20 characters long.\n")
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "city")
    private String city;

    @NotNull
    @Column(name = "role")
    private String role;

}
