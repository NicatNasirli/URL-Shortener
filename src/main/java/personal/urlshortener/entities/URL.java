package personal.urlshortener.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.urlshortener.utilities.Base62Algorithm;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "urls")
public class URL {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;

    private String longURL;

    private LocalDateTime createdAt;

    private int hits;

    @PostPersist
    public void onPostPersist(){
        this.shortCode = Base62Algorithm.encode(this.id);
    }
}
