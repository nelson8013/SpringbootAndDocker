package com.nelly.demo.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nelly.demo.Dto.BookmarksDto;
import com.nelly.demo.Service.BookmarkService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {
  private final BookmarkService  bookmarkService;

 
  @RequestMapping
  public BookmarksDto bookmarks(@RequestParam(name = "page", defaultValue = "1") Integer page){
   return bookmarkService.getBookMarks(page);
  }
}
