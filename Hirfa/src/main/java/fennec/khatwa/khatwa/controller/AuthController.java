package fennec.khatwa.khatwa.controller;


import fennec.khatwa.khatwa.dto.LoginRequest;
import fennec.khatwa.khatwa.dto.SignupRequest;
import fennec.khatwa.khatwa.model.User;
import fennec.khatwa.khatwa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
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
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if (!userService.existsByUsername(username)) {
            return ResponseEntity.badRequest().body("Username not found");
        }

        if (!userService.checkPassword(username, password)) {
            return ResponseEntity.badRequest().body("Invalid password");
        }

        return ResponseEntity.ok("Signed in, Mr/Mrs. " + username);
    }

}