package com.maia.publication.mapper;

import com.maia.publication.controller.request.PublicationRequest;
import com.maia.publication.domain.Publication;
import com.maia.publication.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);

    Publication toPublication(PublicationEntity publicationEntity);

    Publication toPublication(PublicationRequest publicationRequest);
}
