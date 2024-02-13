package com.maia.publication.repository;

import com.maia.publication.domain.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicationRepository extends MongoRepository<Publication, String> {

}
