package security.itpdentityservice.features.user.dto;

public record UserRegisterRequest(
    String username,
    String password
) {}
