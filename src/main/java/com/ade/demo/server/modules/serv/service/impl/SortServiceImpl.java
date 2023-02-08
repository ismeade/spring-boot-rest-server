package com.ade.demo.server.modules.serv.service.impl;

import com.ade.demo.server.modules.serv.mapstruct.SortMapper;
import com.ade.demo.server.modules.serv.service.SortService;
import com.ade.demo.server.modules.serv.service.dto.SortDto;
import com.ade.demo.server.modules.serv.sorter.Sorter;
import com.ade.demo.server.modules.serv.sorter.SorterManager;
import com.ade.demo.server.repository.TSortRepository;
import com.ade.demo.server.repository.entity.TSort;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SortServiceImpl implements SortService {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    protected TSortRepository TSortRepository;
    @Autowired
    protected SortMapper sortMapper;

    @Override
    public List<Object> sort(List<Object> list) {
        // 查找对应数据类型的排序器
        final Sorter sorter = SorterManager.findSorter(list);
        LOG.info("sorter: {}", sorter.getClass());
        // 排序
        final List<Object> sorted = sorter.sort(list);
        // 存库
        saveSort(list, sorted);
        return sorted;
    }

    public List<SortDto> findAll(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by("id").descending());
        final Page<TSort> all = TSortRepository.findAll(pageable);
        return sortMapper.toDto(all.toList());
    }

    private void saveSort(List<Object> origin, List<Object> sorted) {
        TSort tSort = new TSort()
                .setDateOrigin(JSON.toJSONString(origin))
                .setDateSorted(JSON.toJSONString(sorted))
                .setCreateTime(LocalDateTime.now());
        LOG.info("保存到数据库: {}", tSort);
        TSortRepository.save(tSort);
    }

}
