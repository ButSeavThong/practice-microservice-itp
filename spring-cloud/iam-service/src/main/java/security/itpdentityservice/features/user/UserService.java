package security.itpdentityservice.features.user;


import security.itpdentityservice.features.user.dto.UserRegisterRequest;
import security.itpdentityservice.features.user.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRegisterRequest request );
}
