package ru.test.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.test.dto.CountDto;
import ru.test.test.exception.CounterIdNotFoundException;
import ru.test.test.mapper.CountMapper;
import ru.test.test.model.Count;
import ru.test.test.repository.CountRepository;

@Service
@RequiredArgsConstructor
public class CountServiceImpl implements CountService {
    private final CountRepository countRepository;
    private final CountMapper countMapper;

    @Override
    public CountDto create(Count count) {
        if (countRepository.existsByCounterId(count.getCounterId())) {
            throw new CounterIdNotFoundException("That counterId is not exist");
        }
        return countMapper.countToDto(countRepository.save(count));
    }

    @Override
    public CountDto getCount(int counterId) {
        return countMapper.countToDto(countRepository.findAllByCounterId(counterId));
    }
}
