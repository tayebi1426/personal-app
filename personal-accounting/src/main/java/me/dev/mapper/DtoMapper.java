package me.dev.mapper;

public interface DtoMapper<D, E> {
    E convertToEntity(D d);
}
