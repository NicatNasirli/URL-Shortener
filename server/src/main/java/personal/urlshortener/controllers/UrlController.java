package personal.urlshortener.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.urlshortener.business.UrlManager;

import java.net.URI;

@RestController
//@AllArgsConstructor
@RequestMapping("/shorturl.az")
public class UrlController {

    private final UrlManager manager;

    @Autowired
    public UrlController(UrlManager manager) {
        this.manager = manager;
    }

    @PostMapping
    public ResponseEntity<String> generateShortCode(@RequestBody String longUrl) {
        String shortCode = this.manager.add(longUrl);
        return ResponseEntity.ok(shortCode);
    }


    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getLongURL(@PathVariable String shortCode){
        String longUrl = this.manager.getLongUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }
}
