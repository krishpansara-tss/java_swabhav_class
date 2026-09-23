package com.tssconsultancy.core.mapper;

import com.tssconsultancy.core.dto.PageResponseDTO;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class PageMapper<T> {

    public <T> PageResponseDTO<T> toPageResponse(Page<T> page) {
        PageResponseDTO<T> response = new PageResponseDTO<>();

        response.setContent(page.getContent());
        response.setPageNumber(page.getNumber());
        response.setPageSize(page.getSize());
        response.setTotalElements(page.getTotalElements());
        response.setTotalPages(page.getTotalPages());
        response.setLast(page.isLast());

        return response;
    }
}
