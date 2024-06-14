package fr.piroxxi.ruel_li_2.user.dto;

import fr.piroxxi.ruel_li_2.role.Role;
import fr.piroxxi.ruel_li_2.user.User;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

public class UserDTOMapper {
    public static UserDTO fromUser(User user){
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(user, dto);
        dto.setRoles(user.getRoles().stream().map(Role::getName).collect(Collectors.toSet()));
        return dto;
    }
}
