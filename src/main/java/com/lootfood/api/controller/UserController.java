package com.lootfood.api.controller;

import com.lootfood.api.dto.UserDto;
import com.lootfood.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

import static com.lootfood.api.transformer.UserTransformer.transform;

@RestController
@RequestMapping("/api/lootfood/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public UserDto create(@RequestBody UserDto dto) {
        return transform(userService.add(transform(dto)));
    }

    @PutMapping("/{id}")
    public UserDto update(@PathVariable("id") String id, @RequestBody UserDto dto) {
        return transform(id, userService.update(transform(id, dto)));
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable("id") String id) {
        return transform(userService.getById(id));
    }

    @GetMapping(value = "/all")
    public Page<UserDto> getAll(Integer page, Integer size) {
        return userService.getAll(PageRequest.of(page, size)).map(e -> transform(e));
    }
}