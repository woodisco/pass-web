package com.fastcampus.pass.passweb.service.packaze;

import com.fastcampus.pass.passweb.entity.packaze.PackageEntity;
import com.fastcampus.pass.passweb.entity.packaze.Packaze;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PackageModelMapper {
    PackageModelMapper INSTANCE = Mappers.getMapper(PackageModelMapper.class);

    List<Packaze> map(List<PackageEntity> packageEntities);
}