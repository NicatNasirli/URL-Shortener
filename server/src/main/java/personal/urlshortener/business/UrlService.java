package personal.urlshortener.business;

import org.springframework.stereotype.Service;

@Service
public interface UrlService {
    String add(String url);
    String getLongUrl(String shortCode);
}
