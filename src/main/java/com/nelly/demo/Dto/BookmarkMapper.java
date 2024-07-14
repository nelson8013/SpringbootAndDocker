package com.nelly.demo.Dto;

import org.springframework.stereotype.Component;

import com.nelly.demo.Models.Bookmark;

@Component
public class BookmarkMapper {
 
  public BookmarkDto toDTO(Bookmark bookmark){
    BookmarkDto dto = new BookmarkDto();
    dto.setId(bookmark.getId());
    dto.setTitle(bookmark.getTitle());
    dto.setUrl(bookmark.getUrl());
    dto.setCreatedAt(bookmark.getCreatedAt());
    return dto;
  }
}
