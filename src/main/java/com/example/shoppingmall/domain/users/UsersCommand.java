package com.example.shoppingmall.domain.users;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UsersCommand {

    @Setter
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SignUpRequest {
        private String email;
        private String password;
        private String name;
        private String phoneNumber;

        public Users toEntity() {
            return Users.builder()
                    .email(email)
                    .password(new BCryptPasswordEncoder().encode(password))
                    .name(name)
                    .phoneNumber(phoneNumber)
                    .build();
        }
    }

}