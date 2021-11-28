package br.wals.springboot.jwt.data;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserData implements Serializable {

    private String username;
    private String password;

}
