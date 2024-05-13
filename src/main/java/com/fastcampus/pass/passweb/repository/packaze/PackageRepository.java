package com.fastcampus.pass.passweb.repository.packaze;

import com.fastcampus.pass.passweb.entity.packaze.PackageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {

    List<PackageEntity> findAllByOrderByPackageName();
}
