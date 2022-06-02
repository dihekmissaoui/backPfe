package Sbchalet.demo.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Sbchalet.demo.exception.FileNotFoundException;
import Sbchalet.demo.exception.FileStorageException;
import Sbchalet.demo.models.Chalet;
import Sbchalet.demo.models.DatabaseFile;
import Sbchalet.demo.models.Reservation;
import Sbchalet.demo.repository.DatabaseFileRepository;

@Service
public class DatabaseFileService {
	@Autowired
	DatabaseFileRepository dbFileRepository;
	@Autowired
	IChaletService chaletService;
	@Autowired
	IReservationService reservationService;
	private static final Logger logger = Logger.getLogger(DatabaseFileService.class);

	public DatabaseFile storeFile(MultipartFile file, Integer id, String partOf) {
		// Normalize file name
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			logger.info("je suis dans storeFile ()");
			if (fileName.contains("..")) {
				throw new Sbchalet.demo.exception.FileStorageException(
						"Sorry! Filename contains invalid path sequence " + fileName);

			}
			DatabaseFile dbFile = null;
			if (partOf == null && id == null) {
				dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
				return dbFileRepository.save(dbFile);
			} else {
				Object relatedEntity = null;
				if (partOf.equals("chalet")) {
					relatedEntity = chaletService.getChaletById(id);
				}
				if (partOf.equals("reservation")) {
					relatedEntity = reservationService.getReservationById(id);
				}
				if (relatedEntity != null) {
					if (partOf.equals("chalet")) {
						dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(),
								(Chalet) relatedEntity);
					}
					if (partOf.equals("reservation")) {
						dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes(),
								(Reservation) relatedEntity);
					}
					return dbFileRepository.save(dbFile);
				}
			}
		} catch (IOException ex) {
			logger.error("Error :", ex);
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
		return null;

	}

	public DatabaseFile storeOnlyFile(MultipartFile file) {
		// Normalize file name
		String fileName = org.springframework.util.StringUtils.cleanPath(file.getOriginalFilename());
		try {
			// Check if the file's name contains invalid characters
			logger.info("je suis dans storeOnlyFile ()");
			if (fileName.contains("..")) {
				throw new Sbchalet.demo.exception.FileStorageException(
						"Sorry! Filename contains invalid path sequence " + fileName);

			}
			DatabaseFile dbFile = new DatabaseFile(fileName, file.getContentType(), file.getBytes());
			DatabaseFile savedFile =dbFileRepository.save(dbFile);
			System.out.println("SavedFile: "+ savedFile);
			return savedFile;

		} catch (IOException ex) {
			logger.error("Error :", ex);
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	public DatabaseFile getFile(String fileId) {
		try {
			logger.info("je suis dans getFile()");
			logger.debug("findById," + fileId);
			return dbFileRepository.findById(fileId)
					.orElseThrow(() -> new FileNotFoundException("file not found with id " + fileId));

		} catch (Exception e) {
			logger.error("Error avec  DatabaseFileService() :", e);
		}
		logger.info("j'ai terminer l'instruction()");

		return new DatabaseFile();

	}

	public List<DatabaseFile> getAll() {
		try {
			logger.info(" Je suis dans getAllDatabaseFile()   ");
			logger.debug("Je vais retourner List");
			logger.info("Je vien de finir l'operation avec succes ");
			return dbFileRepository.findAll();
		} catch (Exception e) {
			logger.error("Error avec getAllDatabaseFile() :", e);
		}
		return new ArrayList<DatabaseFile>();

	}
	public DatabaseFile updateFileChalet(String id, Chalet chalet) {
		Optional<DatabaseFile> optional = dbFileRepository.findById(id);
		if(optional.isPresent()) {
			DatabaseFile findedFile = optional.get();
			findedFile.setChalet(chalet);
			return dbFileRepository.save(findedFile);
		}
		return null;
	}
}


























