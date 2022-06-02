package Sbchalet.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.services.DatabaseFileService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/files")
public class FileDownloadControllerFile {
	@Autowired
	private DatabaseFileService fileStorageService;

	@GetMapping("/downloadFile/{fileId:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId, HttpServletRequest request) {
		DatabaseFile databaseFile = fileStorageService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(databaseFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; fileName\"" + databaseFile.getFileName() + "\"")
				.body(new ByteArrayResource(databaseFile.getData()));

	}

	@GetMapping("")
	public  List<DatabaseFile> getAll (){
		return fileStorageService.getAll();
	}
}
