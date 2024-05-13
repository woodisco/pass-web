package com.fastcampus.pass.passweb.service.user;

import com.fastcampus.pass.passweb.entity.user.User;
import com.fastcampus.pass.passweb.entity.user.UserEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T14:55:49+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class UserModelMapperImpl implements UserModelMapper {

    @Override
    public User toUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userEntity.getUserId() );
        user.setUserName( userEntity.getUserName() );
        user.setStatus( userEntity.getStatus() );

        return user;
    }
}
