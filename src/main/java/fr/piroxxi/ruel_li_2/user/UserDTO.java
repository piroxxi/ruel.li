package fr.piroxxi.ruel_li_2.user;

import lombok.Data;
import java.util.Set;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String email;
    private String phone;
    private String lang;
    private Set<String> roles;
}
