package com.ade.demo.server.modules.tools.rest;

import com.ade.demo.server.commons.GeneralResult;
import com.ade.demo.server.exception.ReturnException;
import com.ade.demo.server.exception.ReturnExceptionEnum;
import com.ade.demo.server.modules.tools.service.SortService;
import com.ade.demo.server.modules.tools.service.SorterManager;
import com.ade.demo.server.utils.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class SortController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @PostMapping("/sort")
    public ResponseEntity<GeneralResult> sort(@RequestBody List<Object> list,
                                              @RequestParam(required = false, defaultValue = "ase") String sortType) {
        log.info("descend list: {}, sortType: {}", list, sortType);
        // 判断集合中是否是相同类型数据
        if (!CollectionUtils.isClassConsistent(list)) {
            // 有不同的class对象，返回提示，如果有转化策略可以尝试转化
            throw new ReturnException(ReturnExceptionEnum.SORT_ERROR_NOT_SUPPORTED_HETEROGENEOUS_DATA);
        }
        // 查找对应数据类型的排序器
        final SortService sortService = list.stream()
                // 拿出任意一个元素
                .findAny()
                // 转换 -> class -> className -> service
                .map(Object::getClass)
                .map(Class::toString)
                .map(SorterManager::get)
                // 没找到service：不支持该种数据排序
                .orElseThrow(() -> new ReturnException(ReturnExceptionEnum.SORT_ERROR_NOT_SUPPORTED_DATA_FORMAT));
        return ResponseEntity.ok(GeneralResult.success(list));
    }

}
