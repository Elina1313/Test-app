package ru.test.test.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import ru.test.test.dto.CountDto;
import ru.test.test.model.Count;

import java.util.Optional;

@Component
@Mapper(componentModel = "spring")
public interface CountMapper {
    Count toCount(CountDto countDto);
    CountDto countToDto(Optional<Count> count);
}
