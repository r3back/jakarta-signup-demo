package me.reb4ck.glassfishdemo.service.impl;

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.reb4ck.glassfishdemo.entity.UserEntity;
import me.reb4ck.glassfishdemo.repository.UserRepository;
import me.reb4ck.glassfishdemo.service.UserService;
import me.reb4ck.glassfishdemo.service.annotation.DBUserServiceQualifier;

@Slf4j
@NoArgsConstructor
@ApplicationScoped
@DBUserServiceQualifier
@SuppressWarnings("all")
public final class UserServiceImpl implements UserService {
    @Inject
    private UserRepository userRepository;

    @Override
    public void saveEntity(UserEntity user) {
        try {
            userRepository.saveEntity(user);

            log.info("Entity guardada correctamente");
        }catch (Exception e){
            log.error("Error user repository!");
        }
    }
}
