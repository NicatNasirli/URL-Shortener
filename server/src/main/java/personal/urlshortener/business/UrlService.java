package personal.urlshortener.business;

import org.springframework.stereotype.Component;
import personal.urlshortener.dataTransferObjects.GetUrlResponse;


@Component
public interface UrlService {
    String add(String url);
    String getLongUrl(String shortCode);
    void delete(String shortCode);
    GetUrlResponse getUrlByShortCode(String  shortCode);
}
