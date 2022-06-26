package com.example.crud.mapper;

import com.example.crud.domain.Group;
import com.example.crud.service.dto.GroupDTO;
import org.mapstruct.Mapper;

/**
 * The interface Group mapper.
 */
@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface GroupMapper extends EntityMapper<GroupDTO, Group> {

    GroupDTO toDto(Group group);

    Group toEntity(GroupDTO groupDTO);

    /**
     * From id group.
     *
     * @param id the id
     * @return the group
     */
    default Group fromId(String id){
        if(id == null){
            return null;
        }

        Group group = new Group();
        group.setId(id);
        return group;
    }
}
