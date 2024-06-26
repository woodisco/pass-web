package com.fastcampus.pass.passweb.service.packaze;

import com.fastcampus.pass.passweb.entity.packaze.PackageEntity;
import com.fastcampus.pass.passweb.entity.packaze.Packaze;
import com.fastcampus.pass.passweb.repository.packaze.PackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageService {

    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository) {
        this.packageRepository = packageRepository;
    }

    public List<Packaze> getAllPackages() {
        List<PackageEntity> packageEntities = packageRepository.findAllByOrderByPackageName();
        return PackageModelMapper.INSTANCE.map(packageEntities);
    }
}
