package com.spintech.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String email;
    private List<ActorDto> favoriteActor;
    private List<ShowDto> favoriteShow;
}
