package com.example.coupang.interfaces.users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

public class UsersDto {

    @Getter
    @Setter
    @ToString
    public static class SignUpUserRequest {
        @NonNull
        private String name;
        @NonNull
        private String phoneNumber;
        @NonNull
        private String email;
        @NonNull
        private String password;
    }


}