package personal.urlshortener.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CreateURLResponse {
    private Long id;

    private String shortCode;

    private String longURL;

    private LocalDateTime createdAt;

    private int hits;
}
