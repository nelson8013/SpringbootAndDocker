package com.nelly.demo.Dto;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nelly.demo.Models.Bookmark;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookmarksDto {

 List<BookmarkDto> data;
 private Long totalElements;
 private Integer totalPages;
 private Integer currentPage;
 @JsonProperty("isFirst")
 private boolean isFirst;
 @JsonProperty("isLast")
 private boolean isLast;
 private boolean hasNext;
 private boolean hasPrevious;
 

 public BookmarksDto(Page<BookmarkDto> bookmarkPage){
      this.setData(bookmarkPage.getContent());
      this.setTotalElements(bookmarkPage.getTotalElements());
      this.setTotalPages(bookmarkPage.getTotalPages());
      this.setCurrentPage(bookmarkPage.getNumber() + 1);
      this.setFirst(bookmarkPage.isFirst());
      this.setLast(bookmarkPage.isLast());
      this.setHasNext(bookmarkPage.hasNext());
      this.setHasPrevious(bookmarkPage.hasPrevious());
 }
}
