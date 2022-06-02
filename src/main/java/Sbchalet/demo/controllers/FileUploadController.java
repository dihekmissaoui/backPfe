package Sbchalet.demo.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.payload.response.DatabaseFileResponse;
import Sbchalet.demo.services.DatabaseFileService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FileUploadController {
	@Autowired
	DatabaseFileService fileStorageService;

	@RequestMapping(path = "/uploadFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public DatabaseFileResponse uploadFile(@RequestParam("file") MultipartFile file, @RequestParam int elementId,
			@RequestParam String partOf) {

		DatabaseFile filename = fileStorageService.storeFile(file, elementId, partOf);

		return new DatabaseFileResponse(filename.getId(), filename.getFileName(), file.getContentType(), file.getSize(), filename.getData());

	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/uploadOnlyFile", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public DatabaseFileResponse uploadOnlyFile(@RequestParam("file") MultipartFile file) {

		DatabaseFile filename = fileStorageService.storeOnlyFile(file);

		return new DatabaseFileResponse(filename.getId(), filename.getFileName(), file.getContentType(), file.getSize(), filename.getData());

	}

	@PostMapping("/uploadMultiFiles")
	public List<DatabaseFileResponse> uploadMultiFiles(@RequestParam("files") MultipartFile[] files,
			@RequestParam(required = false) Integer elementId, @RequestParam(required = false) String partOf) {
		if (elementId == null && partOf == null) {
			return Arrays.asList(files).stream().map(file -> uploadOnlyFile(file)).collect(Collectors.toList());

		} else
			return Arrays.asList(files).stream().map(file -> uploadFile(file, elementId, partOf))
					.collect(Collectors.toList());
	}

}
