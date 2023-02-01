package me.reb4ck.glassfishdemo.converter.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.reb4ck.glassfishdemo.converter.UserEntityConverter;
import me.reb4ck.glassfishdemo.entity.UserEntity;

import java.util.Optional;

@ApplicationScoped
public final class UserEntityConverterImpl implements UserEntityConverter {
    private static final String FULL_NAME_INPUT = "fullname";
    private static final String PASSWORD_INPUT = "password";
    private static final String EMAIL_INPUT = "email";

    @Override
    public Optional<UserEntity> getUser(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter(FULL_NAME_INPUT);
        String password = request.getParameter(PASSWORD_INPUT);
        String email = request.getParameter(EMAIL_INPUT);

        return Optional.of(UserEntity.builder()
                        .email(email)
                        .password(password)
                        .fullName(fullName)
                        .build());
    }
}
