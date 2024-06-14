package fr.piroxxi.ruel_li_2.auth;

import fr.piroxxi.ruel_li_2.auth.jwt.JwtUtils;
import fr.piroxxi.ruel_li_2.auth.payload.LoginRequest;
import fr.piroxxi.ruel_li_2.auth.payload.LoginResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @GetMapping("/whoami")
    public ResponseEntity<LoginResponse> whoami() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        AuthenticatedUserDetails userDetails = (AuthenticatedUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(new LoginResponse(userDetails.getUsername(), userDetails.getEmail()));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        AuthenticatedUserDetails userDetails = (AuthenticatedUserDetails) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        return ResponseEntity
            .ok()
            .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
            .body(new LoginResponse(userDetails.getUsername(), userDetails.getEmail()));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }
}
