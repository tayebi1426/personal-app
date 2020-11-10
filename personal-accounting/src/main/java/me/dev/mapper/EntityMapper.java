package me.dev.mapper;

public interface EntityMapper<E, D> {

    D convertToDto(E e);
}
