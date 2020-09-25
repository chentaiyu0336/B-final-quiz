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

    //TODO GTB：BUG，再次调用自动分组的时候会有问题
    @PostMapping("/auto-grouping")
    public List<Groups> divideGroup() {
        return groupService.divideGroup();
    }

    //TODO GTB: 如果path为空，可以不写""
    @GetMapping("")
    public List<Groups> getGroups() {
        return groupService.getGroups();
    }
    @PatchMapping("/{group_id}")
    //TODO GTB：组合词，后端一般使用驼峰形式。
    //TODO GTB：@RequestBody一般不用String来接。如果这里是String，当body是{"name": "new name"}这种JSON格式的就会整个String set上去。
    public void updateGroupName(@PathVariable Long group_id, @RequestBody String name) {
        groupService.updateGroupName(group_id, name);
    }
}
