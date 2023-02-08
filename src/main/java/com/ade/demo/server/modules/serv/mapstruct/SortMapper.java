/*
 *  Copyright 2019-2020 Zheng Jie
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.ade.demo.server.modules.serv.mapstruct;


import com.ade.demo.server.modules.serv.rest.vo.SortVo;
import com.ade.demo.server.modules.serv.service.dto.SortDto;
import com.ade.demo.server.repository.entity.TSort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

/**
 * 排序vo dto domain转化mapper
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SortMapper {

    @Mapping(source = "createTime",
            target = "createTime",
            dateFormat = "yyyy-MM-dd HH:mm:ss")
    SortVo toVo(SortDto sortDto);

    @Mapping(source = "createTime",
            target = "createTime",
            dateFormat = "yyyy-MM-dd HH:mm:ss")
    List<SortVo> toVo(List<SortDto> sortDtoList);

    TSort toDto(TSort tSort);

    List<SortDto> toDto(List<TSort> tSortList);

}
