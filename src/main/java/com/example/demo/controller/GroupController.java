package com.example.demo.controller;

import com.example.demo.domain.Groups;
import com.example.demo.service.GroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/auto-grouping")
    public List<Groups> divideGroup() {
        return groupService.divideGroup();
    }

    @GetMapping("")
    public List<Groups> getGroups() {
        return groupService.getGroups();
    }
    @PatchMapping("/{group_id}")
    public void updateGroupName(@PathVariable Long group_id, @RequestBody String name) {
        groupService.updateGroupName(group_id, name);
    }
}
