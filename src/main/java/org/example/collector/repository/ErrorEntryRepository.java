package org.example.collector.repository;

import java.util.List;

import org.example.collector.model.ErrorEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ErrorEntryRepository extends MongoRepository<ErrorEntry, String> {
	List<ErrorEntry> findTop50ByOrderByTimestampDesc();
}
