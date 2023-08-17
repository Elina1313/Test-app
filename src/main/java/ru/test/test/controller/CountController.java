package ru.test.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.test.test.dto.CountDto;
import ru.test.test.model.Count;
import ru.test.test.service.CountService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/counts")
@Valid
public class CountController {

    private CountService countService;

    @GetMapping("/{counterId}")
    @ResponseStatus(HttpStatus.OK)
    public CountDto getCount(@PathVariable @Positive int counterId) {
        return countService.getCount(counterId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CountDto incrementCount(@Valid @RequestBody Count count) {
        return countService.incrementCount(count);
    }

}
