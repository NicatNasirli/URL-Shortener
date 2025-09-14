package personal.urlshortener.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import personal.urlshortener.dataAccess.URLRepository;

@Component
@AllArgsConstructor
public class URLManager implements URLService {

    private final URLRepository repository;


}
