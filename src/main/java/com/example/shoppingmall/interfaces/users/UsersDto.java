package com.example.shoppingmall.interfaces.users;

import com.example.shoppingmall.domain.enums.SignUpType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.NonNull;

public class UsersDto {

    @Getter
    @Setter
    @ToString
    public static class SignInUserRequest {
        @NonNull
        private String email;
        @NonNull
        private String password;
    }


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
        @NonNull
        private SignUpType signUpType;
    }

    @Getter
    @Setter
    @ToString
    public static class SignUpUserResponse {
        private Boolean isSuccess;
    }

    @Getter
    @Setter
    @ToString
    public static class SignUpCheckEmailRequest {
//        @NonNull
        private String email;
    }

    @Getter
    @Setter
    @ToString
    public static class SignUpCheckEmailResponse {
        private Boolean isDuplicated;
    }


}
