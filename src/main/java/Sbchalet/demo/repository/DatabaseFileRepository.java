package Sbchalet.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Sbchalet.demo.models.DatabaseFile;
@Repository
public interface DatabaseFileRepository extends JpaRepository <DatabaseFile, String> {

}
