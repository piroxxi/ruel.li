package fr.piroxxi.ruel_li_2.alley;

import fr.piroxxi.ruel_li_2.alley.dto.AlleyDTO;
import fr.piroxxi.ruel_li_2.alley.dto.AlleyDTOMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/alleys")
@RequiredArgsConstructor
public class AlleyController {
    private final AlleyRepository repository;

    @GetMapping
    public ResponseEntity<Iterable<AlleyDTO>> listAll() {
        List<AlleyDTO> alleyDtos = StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(AlleyDTOMapper::fromAlley)
                .collect(Collectors.toList());

        return ResponseEntity.ok(alleyDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlleyDTO> getAlley(@PathVariable("id") String id) {
        Alley alley = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find alley with ID " + id));
        return ResponseEntity.ok(AlleyDTOMapper.fromAlley(alley));
    }
}
