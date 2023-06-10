package movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import movie.dto.AnnouncementDto;
import movie.mapper.AnnouncementMapper;

@RestController
public class AnnouncementApiController {

	@Autowired
	AnnouncementMapper announcementMapper;
	

	@GetMapping("/api/announcement")
	public ResponseEntity<List<AnnouncementDto>>listAnnouncement() throws Exception {
		List<AnnouncementDto> announcementDto = announcementMapper.listAnnouncement();
		if (announcementDto == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(announcementDto);
		}
	}
}
