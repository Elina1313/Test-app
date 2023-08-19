package ru.test.test.service;

import ru.test.test.dto.CountDto;
import ru.test.test.model.Count;

public interface CountService {

    Count getCount(int counterId);

    Count incrementCount(Count count);
}
