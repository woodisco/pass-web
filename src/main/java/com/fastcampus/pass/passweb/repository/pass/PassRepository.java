package com.fastcampus.pass.passweb.repository.pass;

import com.fastcampus.pass.passweb.entity.pass.PassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
    @Query(value = "select p from PassEntity p " +
            "join fetch p.packageEntity " +
            "where p.userId = :userId " +
            "order by p.endedAt desc nulls first ")
    List<PassEntity> findByUserId(@Param("userId") String userId);
}
