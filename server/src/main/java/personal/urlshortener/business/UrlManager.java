package personal.urlshortener.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.urlshortener.dataAccess.UrlRepository;
import personal.urlshortener.dataTransferObjects.GetUrlResponse;
import personal.urlshortener.entities.MyUrl;
import personal.urlshortener.utilities.Base62Algorithm;
import personal.urlshortener.utilities.Mapper;

import java.util.Optional;


@Service
public class UrlManager implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    public UrlManager(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

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

    @Override
    public void delete(String shortCode) {
        this.urlRepository.delete(
                this.urlRepository.findByShortCode(shortCode).get());
    }

    @Override
    public GetUrlResponse getUrlByShortCode(String shortCode) {
        return Mapper.createURLResponse(this.urlRepository.findByShortCode(shortCode).get());
    }


}

