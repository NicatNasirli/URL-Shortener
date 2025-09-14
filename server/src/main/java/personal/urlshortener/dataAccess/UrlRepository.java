package personal.urlshortener.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.urlshortener.entities.MyUrl;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<MyUrl, Long> {

    Optional<MyUrl> findByShortCode(String shortCode);
}
