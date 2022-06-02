package Sbchalet.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import Sbchalet.demo.models.Chalet;

@Repository
public interface ChaletRepository extends JpaRepository<Chalet, Integer>{
}
