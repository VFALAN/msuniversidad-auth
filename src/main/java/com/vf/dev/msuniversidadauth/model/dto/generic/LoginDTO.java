package com.vf.dev.msuniversidadauth.model.dto.generic;

import lombok.*;

import javax.persistence.GeneratedValue;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO implements Serializable {
    private String username;
    private String password;
}
