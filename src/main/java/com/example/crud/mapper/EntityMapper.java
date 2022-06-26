package com.example.crud.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * The interface Entity mapper.
 *
 * @param <D> the type parameter
 * @param <E> the type parameter
 */
public interface EntityMapper<D, E> {

    /**
     * To entity e.
     *
     * @param dto the dto
     * @return the e
     */
    E toEntity(D dto);

    /**
     * To dto d.
     *
     * @param entity the entity
     * @return the d
     */
    D toDto(E entity);

    /**
     * To entity list.
     *
     * @param dtoList the dto list
     * @return the list
     */
    List<E> toEntity(List<D> dtoList);

    /**
     * To dto list.
     *
     * @param entityList the entity list
     * @return the list
     */
    List<D> toDto(List<E> entityList);

    /**
     * Partial update.
     *
     * @param entity the entity
     * @param dto    the dto
     */
    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget E entity, D dto);
}
