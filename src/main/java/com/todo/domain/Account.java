package com.todo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Data
public class Account {
    private UUID id;
    private String login;
    private String password;
}
