package com.fastcampus.pass.passweb.entity.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {

    private String userId;

    private String userName;

    private UserStatus status;
}