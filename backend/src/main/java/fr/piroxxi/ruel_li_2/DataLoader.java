package fr.piroxxi.ruel_li_2;

import fr.piroxxi.ruel_li_2.alley.Alley;
import fr.piroxxi.ruel_li_2.alley.AlleyRepository;
import fr.piroxxi.ruel_li_2.role.Role;
import fr.piroxxi.ruel_li_2.role.RoleName;
import fr.piroxxi.ruel_li_2.role.RoleRepository;
import fr.piroxxi.ruel_li_2.user.User;
import fr.piroxxi.ruel_li_2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import static fr.piroxxi.ruel_li_2.role.RoleName.ADMIN;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final AlleyRepository alleyRepository;
    private final PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        for (RoleName name : RoleName.values()) {
            roleRepository.save(Role.builder().name(name.name()).build());
        }
        User piroxxiAdmin = userService.createUser(
                User.builder()
                        .username("piroxxi")
                        .email("piroxxi@gmail.com")
                        .password(passwordEncoder.encode("letmein"))
                        .lang("fr")
                        .enabled(true)
                        .isNotLocked(true)
                        .build()
        );

        userService.addRole(piroxxiAdmin, ADMIN);

        alleyRepository.save(
                Alley.builder()
                        .name("Ruelle Boyer/Christophe-Colomb Bellechasse/Beaubien")
                        .shortname("bbbcc")
                        .imageUrl("/assets/blank_alley.png")
                        .build()
        );
        alleyRepository.save(
                Alley.builder()
                        .name("Ruelle de test")
                        .shortname("test")
                        .imageUrl("/assets/blank_alley.png")
                        .build()
        );
    }
}