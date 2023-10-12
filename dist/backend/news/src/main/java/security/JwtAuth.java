package security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import services.AdminService;
import services.UserService;
import services.VisitorService;

@Component
public class JwtAuth {


    private final AdminService adminService;
    private final UserService userService;
    private final VisitorService visitorService;

    public JwtAuth(AdminService adminService, UserService userService, VisitorService visitorService) {
        this.adminService = adminService;
        this.userService = userService;
        this.visitorService = visitorService;
    }

    public Authentication JwtAuthentication(String jwtToken){
        return null; // TODO add authentication
    }

}
