package fr.piroxxi.ruel_li_2.alley;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(NON_DEFAULT)
public class Alley {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotEmpty(message = "Alley name cannot be empty")
    private String name;
    @NotEmpty(message = "Alley shortname cannot be empty")
    private String shortname;
    private String imageUrl;
}
