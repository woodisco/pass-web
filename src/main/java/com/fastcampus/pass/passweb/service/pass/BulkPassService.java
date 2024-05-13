package com.fastcampus.pass.passweb.service.pass;

import com.fastcampus.pass.passweb.controller.admin.BulkPassRequest;
import com.fastcampus.pass.passweb.entity.packaze.PackageEntity;
import com.fastcampus.pass.passweb.entity.pass.BulkPassEntity;
import com.fastcampus.pass.passweb.entity.pass.BulkPassStatus;
import com.fastcampus.pass.passweb.repository.packaze.PackageRepository;
import com.fastcampus.pass.passweb.repository.pass.BulkPassRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BulkPassService {

    private final BulkPassRepository bulkPassRepository;

    private final PackageRepository packageRepository;

    public BulkPassService(BulkPassRepository bulkPassRepository, PackageRepository packageRepository) {
        this.bulkPassRepository = bulkPassRepository;
        this.packageRepository = packageRepository;
    }

    public List<BulkPass> getAllBulkPasses() {
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        PackageEntity packageEntity = packageRepository.findById(bulkPassRequest.getPackageSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(packageEntity.getCount());
        bulkPassEntity.setEndedAt(packageEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }
}