package com.example.crud.web;

import com.example.crud.service.GroupService;
import com.example.crud.service.dto.GroupDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * The type Group resource.
 */
@RestController
@CrossOrigin(origins = {"http://localhost:3000"}, maxAge = 3600)
public class GroupResource {

    private final Logger log = LoggerFactory.getLogger(GroupResource.class);

    private final GroupService groupService;

    /**
     * Instantiates a new Group resource.
     *
     * @param groupService the group service
     */
    public GroupResource(GroupService groupService) {
        this.groupService = groupService;
    }

    /**
     * Get all groups response entity.
     *
     * @return the response entity
     */
    @GetMapping("/groups")
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        log.info("REST request to get all Groups.");
        List<GroupDTO> allGroups = groupService.findAll();
        return ResponseEntity.ok(allGroups);
    }

    /**
     * Get group response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/groups/{id}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable Long id) {
        log.info("REST request to get Group by id: {}", id);
        GroupDTO groupDTO = groupService.findOne(id);
        return ResponseEntity.ok(groupDTO);
    }

    /**
     * Create group response entity.
     *
     * @param groupDTO the group dto
     * @return the response entity
     */
    @PostMapping("/groups")
    public ResponseEntity<GroupDTO> createGroup(@RequestBody GroupDTO groupDTO) {
        log.info("REST request to create Group: {}", groupDTO);
        GroupDTO newGroup = groupService.save(groupDTO);
        return ResponseEntity.created(URI.create("/api/v1/groups")).body(newGroup);
    }

    /**
     * Partial update group entity.
     *
     * @param groupDTO the group dto
     * @return the response entity
     */
    @PatchMapping("/groups/{id}")
    public ResponseEntity<GroupDTO> partialUpdateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO) {
        log.info("REST request to partially update Group: {}", groupDTO);
        GroupDTO partialUpdatedGroup = groupService.partialUpdate(id, groupDTO);
        return ResponseEntity.ok(partialUpdatedGroup);
    }

    @DeleteMapping("/groups/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        log.info("REST request to delete Group by id: {}", id);
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
