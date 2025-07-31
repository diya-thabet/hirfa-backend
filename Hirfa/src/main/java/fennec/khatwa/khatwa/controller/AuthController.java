package fennec.khatwa.khatwa.controller;

import fennec.khatwa.khatwa.dto.LoginRequest;
import fennec.khatwa.khatwa.dto.SignupRequest;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.security.JwtUtil;
import fennec.khatwa.khatwa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


    private final UserService userService;


    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        if (signupRequest.getUsername().equals("")) {
            return ResponseEntity.badRequest().body("Invalid Name");
        }
        if (userService.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        if (!signupRequest.getRole().equals("USER") && !signupRequest.getRole().equals("FREELANCER")) {
            return ResponseEntity.badRequest().body("Invalid role");
        }

        User user = new User();
        user.setUsername(signupRequest.getUsername());
        user.setPassword(signupRequest.getPassword());
        user.setEmail(signupRequest.getEmail());
        user.setRole(signupRequest.getRole());

        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/signin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            // Use Spring Security's AuthenticationManager to check credentials
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            // If no exception, credentials are valid → generate token
            User user = (User) userService.findByUsername(loginRequest.getUsername()).orElseThrow();
            String token = jwtUtil.generateToken(user);

            // Return JWT token
            return ResponseEntity.ok(Map.of("token", token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
