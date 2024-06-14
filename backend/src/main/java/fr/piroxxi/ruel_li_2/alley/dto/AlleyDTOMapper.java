package fr.piroxxi.ruel_li_2.alley.dto;

import fr.piroxxi.ruel_li_2.alley.Alley;
import org.springframework.beans.BeanUtils;

import java.util.stream.Collectors;

public class AlleyDTOMapper {
    public static AlleyDTO fromAlley(Alley alley){
        AlleyDTO dto = new AlleyDTO();
        BeanUtils.copyProperties(alley, dto);
        dto.setImage(alley.getImageUrl());
        return dto;
    }
}
