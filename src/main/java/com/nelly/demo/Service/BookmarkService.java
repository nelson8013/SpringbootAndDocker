package com.nelly.demo.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nelly.demo.Dto.BookmarkDto;
import com.nelly.demo.Dto.BookmarkMapper;
import com.nelly.demo.Dto.BookmarksDto;
import com.nelly.demo.Models.Bookmark;
import com.nelly.demo.Repositories.BookmarkRepo;

import lombok.RequiredArgsConstructor;



@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {
 
 private final BookmarkRepo repo;

 @Transactional(readOnly = true)
 public BookmarksDto getBookMarks(Integer page){
  int pageNo = page < 1 ? 0 : page -1;
  Pageable pageable = PageRequest.of(pageNo, 3, Sort.Direction.DESC, "createdAt");
  Page<BookmarkDto> bookmarkPage = repo.findBookmarks(pageable);
  return new BookmarksDto(bookmarkPage);
 }

}
