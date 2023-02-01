package me.reb4ck.glassfishdemo.converter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.reb4ck.glassfishdemo.entity.UserEntity;

import java.util.Optional;

public interface UserEntityConverter {
    Optional<UserEntity> getUser(HttpServletRequest request, HttpServletResponse response);
}
