package fr.piroxxi.ruel_li_2;

import fr.piroxxi.ruel_li_2.user.User;
import fr.piroxxi.ruel_li_2.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) {
        userRepository.save(
                User.builder()
                        .username("piroxxi")
                        .email("piroxxi@gmail.com")
                        .password(passwordEncoder.encode("letmein"))
                        .lang("fr")
                        .enabled(true)
                        .isNotLocked(true)
                        .build()
        );
    }
}