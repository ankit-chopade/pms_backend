package com.pms.schedule.utils;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseConverter<E, D> {

	E toEntity(D dto);

	D toDto(E entity);

	default List<E> toEntity(List<D> list) {
		return list.stream().map(this::toEntity).collect(Collectors.toList());
	}

	default List<D> toDto(List<E> list) {
		return list.stream().map(this::toDto).collect(Collectors.toList());
	}

}
