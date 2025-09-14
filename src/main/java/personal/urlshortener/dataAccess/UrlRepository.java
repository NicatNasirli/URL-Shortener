package personal.urlshortener.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.urlshortener.entities.URL;

@Repository
public interface URLRepository extends JpaRepository<URL, Long> {
}
