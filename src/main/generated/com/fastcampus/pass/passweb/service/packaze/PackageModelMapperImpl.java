package com.fastcampus.pass.passweb.service.packaze;

import com.fastcampus.pass.passweb.entity.packaze.PackageEntity;
import com.fastcampus.pass.passweb.entity.packaze.Packaze;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-13T14:55:49+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18.0.2 (Amazon.com Inc.)"
)
public class PackageModelMapperImpl implements PackageModelMapper {

    @Override
    public List<Packaze> map(List<PackageEntity> packageEntities) {
        if ( packageEntities == null ) {
            return null;
        }

        List<Packaze> list = new ArrayList<Packaze>( packageEntities.size() );
        for ( PackageEntity packageEntity : packageEntities ) {
            list.add( packageEntityToPackaze( packageEntity ) );
        }

        return list;
    }

    protected Packaze packageEntityToPackaze(PackageEntity packageEntity) {
        if ( packageEntity == null ) {
            return null;
        }

        Packaze packaze = new Packaze();

        packaze.setPackageSeq( packageEntity.getPackageSeq() );
        packaze.setPackageName( packageEntity.getPackageName() );

        return packaze;
    }
}
