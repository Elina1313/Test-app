package ru.test.test.service;

import ru.test.test.dto.CountDto;
import ru.test.test.model.Count;

public interface CountService {

    CountDto create(Count count);

    CountDto getCount(int counterId);
}
