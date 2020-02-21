package com.spintech.testtask.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowDto {

    private Long id;

    private String name;

    private List<ActorDto> actors;
}
