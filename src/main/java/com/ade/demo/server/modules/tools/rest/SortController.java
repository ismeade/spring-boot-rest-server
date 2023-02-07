package com.ade.demo.server.modules.tools.rest;

import com.ade.demo.server.commons.GeneralResult;
import com.ade.demo.server.modules.tools.service.SortService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tools")
public class SortController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected SortService sortService;

    @PostMapping("/sort")
    public ResponseEntity<GeneralResult> sort(@RequestBody List<Object> list) {
        LOG.info("sort list: {}", list);
        final List<Object> sortedList = sortService.sort(list);
        LOG.info("result list: {}", sortedList);
        return ResponseEntity.ok(GeneralResult.success(sortedList));
    }

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor());
//    }

}
