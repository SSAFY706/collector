package org.example.collector.model;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "errors")
public class ErrorEntry {
	@Id
	private String id;
	private String className;
	private String methodName;
	private String message;
	private String stackTrace;
	private Instant timestamp;
}
