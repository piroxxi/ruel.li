package fr.piroxxi.ruel_li_2.resource;

import fr.piroxxi.ruel_li_2.resource.payload.ResourceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ResourceController {
    private final String instanceID = UUID.randomUUID().toString();

    @RequestMapping("/resource")
    public ResponseEntity<ResourceResponse> home() {
        return ResponseEntity.ok(new ResourceResponse(instanceID, "Ruel.li"));
    }
}
