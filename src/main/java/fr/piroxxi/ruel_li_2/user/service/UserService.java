package fr.piroxxi.ruel_li_2.user.service;

import fr.piroxxi.ruel_li_2.role.RoleName;
import fr.piroxxi.ruel_li_2.role.RoleRepository;
import fr.piroxxi.ruel_li_2.user.User;
import fr.piroxxi.ruel_li_2.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find user with ID "+id));
    }

    public User createUser(User user) {
        if (CollectionUtils.isEmpty(user.getRoles())) {
            user.addRole(roleRepository.findByName(RoleName.USER.name()).orElseThrow(() -> new EntityNotFoundException("Cannot find role for User")));
        }
        return userRepository.save(user);
    }

    public void addRole(User user, RoleName roleName) {
        if (CollectionUtils.isEmpty(user.getRoles())) {
            user.addRole(roleRepository.findByName(roleName.name()).orElseThrow(() -> new EntityNotFoundException("Cannot find role for with name "+roleName)));
        }
        userRepository.save(user);
    }
}
