package org.example.collector.controller;

import java.util.List;

import org.example.collector.model.ErrorEntry;
import org.example.collector.repository.ErrorEntryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ErrorCollectorController {
	private final ErrorEntryRepository repo;

	/** Collector로부터 에러 데이타 수신 */
	@PostMapping("/apm/error")
	public ResponseEntity<Void> ingest(@RequestBody ErrorEntry entry) {
		System.out.println("[Collector] Received error: " +
			entry.getClassName() + "#" + entry.getMethodName());
		repo.save(entry);
		return ResponseEntity.accepted().build();
	}

	/** 최근 에러 50건 조회 */
	@GetMapping("/api/error/recent")
	public List<ErrorEntry> recent() {
		return repo.findTop50ByOrderByTimestampDesc();
	}
}
