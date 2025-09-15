package personal.urlshortener.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import personal.urlshortener.business.UrlManager;

import java.net.URI;

@RestController
@RequestMapping("/shorturl.az")
@CrossOrigin(origins = "*")
public class UrlController {

    private final UrlManager urlManager;

    @Autowired
    public UrlController(UrlManager urlManager) {
        this.urlManager = urlManager;
    }

    @PostMapping
    public ResponseEntity<String> generateShortCode(@RequestBody String longUrl) {
        String shortCode = this.urlManager.add(longUrl);
        return ResponseEntity.ok(shortCode);
    }


    @GetMapping("/{shortCode}")
    public ResponseEntity<Void> getLongURL(@PathVariable String shortCode) {
        String longUrl = this.urlManager.getLongUrl(shortCode);

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<String> deleteLongUrl(@PathVariable String shortCode) {
        this.urlManager.delete(shortCode);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/{shortCode}/obj")
    public ResponseEntity<Void> getUrlBody(@PathVariable String shortCode) {
        this.urlManager.getUrlByShortCode(shortCode);
        return ResponseEntity.status(HttpStatus.FOUND).build();
    }
}
