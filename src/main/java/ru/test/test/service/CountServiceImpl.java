package ru.test.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.test.test.dto.CountDto;
import ru.test.test.exception.CounterIDAndIncrementCountMismatchException;
import ru.test.test.exception.CounterIdNotExistException;
import ru.test.test.mapper.CountMapper;
import ru.test.test.model.Count;
import ru.test.test.repository.CountRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountServiceImpl implements CountService {

    private final CountRepository countRepository;

    private final CountMapper countMapper;

    @Override
    public CountDto getCount(int counterId) {

        /*if (!countRepository.existsByCounterId(String.valueOf(counterId))) {
            throw new CounterIdNotExistException("CounterId is not exist");
        }
        return countMapper.countToDto(countRepository.findByCounterId(valueOf(counterId)));*/

        return countMapper.countToDto(Optional.ofNullable(countRepository.findById(counterId)
                .orElseThrow(() -> new CounterIdNotExistException("No such counter id " + counterId))));

    }

    @Override
    public CountDto incrementCount(Count count) {
        if (!countRepository.existsByCounterId(count.getCounterId())) {
            throw new CounterIdNotExistException("CounterId is not exist" + count.getCounterId());
        }
        if (countRepository.findByCounterId(String.valueOf(count.getCounterId().isEmpty())) ||
                !countRepository.findByCounterId(String.valueOf(count.getIncrementCount())) ||
                !countRepository.findByCounterId(String.valueOf(String.valueOf(count.getIncrementCount()).matches("\\d+"))) ||
                !countRepository.findByCounterId(String.valueOf(count.getIncrementCount() > 0))
        ) {
            throw new CounterIDAndIncrementCountMismatchException("CounterID and/or incrementCount is not correct");
        }

        return countMapper.countToDto(Optional.of(countRepository.save(count)));
    }
}
