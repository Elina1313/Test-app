package ru.test.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.test.test.exception.ValidationException;
import ru.test.test.exception.NotFoundException;
import ru.test.test.model.Count;
import ru.test.test.repository.CountRepository;

@Service
@RequiredArgsConstructor
public class CountServiceImpl implements CountService {

    private final CountRepository countRepository;

    @Transactional(readOnly = true)
    @Override
    public Count getCount(int counterId) {

        return countRepository.findById(counterId).orElseThrow(
                () -> new NotFoundException("Counter id " + counterId + " not found")
        );
    }

    @Override
    public Count incrementCount(Count count) {
        if (!countRepository.existsByCounterId(count.getCounterId())) {
            throw new NotFoundException("CounterId is not exist" + count.getCounterId());
        }
        if (countRepository.findByCounterId(String.valueOf(count.getCounterId().isEmpty())) ||
                !countRepository.findByCounterId(String.valueOf(count.getIncrementCount())) ||
                !countRepository.findByCounterId(String.valueOf(String.valueOf(count.getIncrementCount()).matches("\\d+"))) ||
                !countRepository.findByCounterId(String.valueOf(count.getIncrementCount() > 0))
        ) {
            throw new ValidationException("CounterID and/or incrementCount is not correct");
        }

        return countRepository.save(count);
    }
}
