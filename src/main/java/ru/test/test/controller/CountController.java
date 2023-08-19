package ru.test.test.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.test.test.dto.CountDto;
import ru.test.test.mapper.CountMapper;
import ru.test.test.model.Count;
import ru.test.test.service.CountService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/counts")
@Valid
public class CountController {

    private CountService countService;

    private final CountMapper countMapper;

    @GetMapping("/{counterId}")
    @ResponseStatus(HttpStatus.OK)
    public CountDto getCount(@PathVariable @Positive int counterId) {
        log.debug("request to get count id: {]", counterId);
        return countMapper.countToDto(countService.getCount(counterId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CountDto incrementCount(@Valid @RequestBody Count count) {
        return countMapper.countToDto(countService.incrementCount(count));
    }

}
