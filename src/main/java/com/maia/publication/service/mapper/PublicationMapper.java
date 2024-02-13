package com.maia.publication.service.mapper;

import com.maia.publication.domain.Publication;
import com.maia.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);
}
