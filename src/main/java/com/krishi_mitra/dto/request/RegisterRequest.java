package com.krishi_mitra.dto.request;

import com.krishi_mitra.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {
    @NotBlank
    private String name;

    @Email
    private String email;

    @NotBlank
    private String password;

    private String phone;
    private String address;

    private Role role;
}
