package com.spintech.testtask.util;

import com.spintech.testtask.dto.ActorDto;
import com.spintech.testtask.dto.ShowDto;
import com.spintech.testtask.entity.Actor;
import com.spintech.testtask.entity.Show;

import java.util.List;
import java.util.stream.Collectors;

public final class UtilMapper {

    private UtilMapper() {
    }

    public static List<ActorDto> toActorDto(List<Actor> favoriteShow) {

        return favoriteShow.stream()
                .map(actor -> new ActorDto(actor.getId(), actor.getName()))
                .collect(Collectors.toList());
    }

    public static List<ShowDto> toShowDto(List<Show> favoriteShow) {

        return favoriteShow.stream()
                .map(show -> new ShowDto(show.getId(), show.getName(), toActorDto(show.getActors())))
                .collect(Collectors.toList());
    }
}
