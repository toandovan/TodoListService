package com.example.todolistservice.entity;

import com.example.todolistservice.util.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto  implements Serializable {
    private long id;
    private String username;
    private String token;
    private Role role;
}
