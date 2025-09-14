package personal.urlshortener.dataTransferObjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetUrlResponse {
    private Long id;

    private String shortCode;

    private String longUrl;

    private LocalDateTime createdAt;

    private int hits;
}
