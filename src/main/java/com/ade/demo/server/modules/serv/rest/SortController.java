package com.ade.demo.server.modules.serv.rest;

import com.ade.demo.server.commons.GeneralResult;
import com.ade.demo.server.modules.serv.mapstruct.SortMapper;
import com.ade.demo.server.modules.serv.service.SortService;
import com.ade.demo.server.modules.serv.service.dto.SortDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/serv")
public class SortController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected SortMapper sortMapper;
    @Autowired
    protected SortService sortService;

    /**
     * 排序
     * @param list 排序数据
     * @return 排序后数据
     */
    @PostMapping("/sort")
    public ResponseEntity<GeneralResult> sort(@RequestBody List<Object> list) {
        LOG.info("sort list: {}", list);
        final List<Object> sortedList = sortService.sort(list);
        LOG.info("result list: {}", sortedList);
        return ResponseEntity.ok(GeneralResult.success(sortedList));
    }

    /**
     * 获取排序记录
     * @param page 页数 默认0
     * @param pageSize 每页数量 默认10
     * @return 结果vo
     */
    @GetMapping("/sorts")
    public ResponseEntity<GeneralResult> getAll(@RequestParam(required = false, defaultValue = "0") Integer page,
                                                @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        LOG.info("getAll page: {}, pageSize: {}", page, pageSize);
        final List<SortDto> all = sortService.findAll(page, pageSize);
        return ResponseEntity.ok(GeneralResult.success(sortMapper.toVo(all)));
    }

}
