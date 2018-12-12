package com.cloud.system.api;

import com.cloud.common.Page;
import com.cloud.common.PageResult;
import com.cloud.system.api.dto.AdminDto;
import com.cloud.system.api.dto.LoginDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author: zhangchao
 * @time: 2018-08-21 15:02
 **/
@RestController
@RequestMapping("/system")
public interface SystemClient {

    @PostMapping("/login")
    String login(@RequestBody LoginDto loginDto);

    @GetMapping("/admin/{id}")
    AdminDto getAdmin(@PathVariable("id") String id);

    @GetMapping("/admin")
    PageResult<AdminDto> list(Page<AdminDto> page);

    @PostMapping("/admin")
    String saveAdmin(@RequestBody AdminDto adminDto);

    @PutMapping("/admin")
    void updateAdmin(@RequestBody AdminDto adminDto);

    @DeleteMapping("/admin/{id}")
    void deleteAdmin(@PathVariable("id") String id);
}
