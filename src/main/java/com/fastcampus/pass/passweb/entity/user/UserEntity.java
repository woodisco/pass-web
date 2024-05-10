package com.fastcampus.pass.passweb.entity.user;

import com.fastcampus.pass.passweb.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import jakarta.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="user")
public class UserEntity extends BaseEntity {
    @Id
    private String userId;

    private String userName;
    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private String phone;

    private String meta;
}