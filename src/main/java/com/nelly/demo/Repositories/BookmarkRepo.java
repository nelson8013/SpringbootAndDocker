package com.nelly.demo.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nelly.demo.Dto.BookmarkDto;

import com.nelly.demo.Dto.BookmarkDto;
import com.nelly.demo.Models.Bookmark;

public interface BookmarkRepo extends JpaRepository<Bookmark, Long>{

 @Query("select new com.nelly.demo.Dto.BookmarkDto(b.id, b.title, b.url, b.createdAt) from Bookmark b")
 Page<BookmarkDto> findBookmarks(Pageable pageable);
}
