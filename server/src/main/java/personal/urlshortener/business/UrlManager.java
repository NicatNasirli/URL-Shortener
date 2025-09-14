package personal.urlshortener.business;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personal.urlshortener.dataAccess.UrlRepository;
import personal.urlshortener.entities.MyUrl;
import personal.urlshortener.utilities.Base62Algorithm;

import java.util.Optional;

@Component
//@AllArgsConstructor
public class UrlManager implements UrlService {

    @Autowired
    public UrlManager(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    private final UrlRepository urlRepository;

    @Override
    public String  add(String longUrl) {

        MyUrl savedUrl = new MyUrl();
        savedUrl.setLongUrl(longUrl);
        savedUrl.setHits(0);

        this.urlRepository.save(savedUrl);

        savedUrl.setShortCode(Base62Algorithm.encode(savedUrl.getId()));

        this.urlRepository.save(savedUrl);

        return savedUrl.getShortCode();
    }

    @Override
    public String getLongUrl(String shortCode) {
        Optional<MyUrl> url = this.urlRepository.findByShortCode(shortCode);
        if (url.isPresent()){
            MyUrl presentUrl = url.get();
            presentUrl.setHits(presentUrl.getHits() + 1);
            this.urlRepository.save(presentUrl);

            return presentUrl.getLongUrl();

        }else return null;
    }



}
