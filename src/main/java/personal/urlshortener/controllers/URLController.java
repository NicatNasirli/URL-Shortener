package personal.urlshortener.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.urlshortener.business.URLManager;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shortUrl")
public class URLController {

    private final URLManager manager;

}
