package com.fastcampus.pass.passweb.repository.user;

import com.fastcampus.pass.passweb.entity.user.UserGroupMappingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserGroupMappingRepository extends JpaRepository<UserGroupMappingEntity, Integer> {

    @Query("select distinct u.userGroupId " +
            "from UserGroupMappingEntity u " +
            "order by u.userGroupId")
    List<String> findDistinctUserGroupId();
}