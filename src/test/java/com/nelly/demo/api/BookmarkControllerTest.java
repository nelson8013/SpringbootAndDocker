package com.nelly.demo.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import com.nelly.demo.Models.Bookmark;
import com.nelly.demo.Repositories.BookmarkRepo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(properties = {
        "spring.datasource.url=jdbc:tc:mysql:8.0.28:///test"
})
class BookmarkControllerTest {

    @Autowired
    private MockMvc mvc;
    
    @Autowired
    BookmarkRepo repo;


    private List<Bookmark> bookmarks;
    
    @BeforeEach
    void setup(){
        repo.deleteAllInBatch();
        bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "Sivalabs", "https://sivalabs.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Gotcha", "https://gotcha.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Primack", "https://primack.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Groot", "https://groot.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "GEoogle", "https://google.io", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Azure", "https://azure.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Digital Ocean", "https://digital-ocean.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Achebe", "https://achebe.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Fox Knox", "https://fox-nox.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Crime Wave", "https://crime-wave.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Founder Fountain", "https://founder-fountain.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Some Things", "https://somethings.in", Instant.now() ));
        bookmarks.add(new Bookmark(null, "Now Way", "https://no-way.in", Instant.now() ));

        repo.saveAll(bookmarks);
    }

    @ParameterizedTest
    @CsvSource({
            "1,13,5,1,true,false,true,false",
            "2,13,5,2,false,false,true,true"
    })
    void shouldGetBookmarks(int pageNo, int totalElements, int totalPages,
                            int currentPage, boolean isFirst, boolean isLast, boolean hasNext, boolean hasPrevious) throws Exception{
     mvc.perform(get("/api/bookmarks?page=" + pageNo))
        .andExpect( status().isOk())
        .andExpect( jsonPath("$.totalElements", CoreMatchers.equalTo(totalElements)))
        .andExpect( jsonPath("$.totalPages", CoreMatchers.equalTo(totalPages)))
        .andExpect( jsonPath("$.currentPage", CoreMatchers.equalTo(currentPage)))
        .andExpect( jsonPath("$.isFirst", CoreMatchers.equalTo(isFirst)))
        .andExpect( jsonPath("$.isLast", CoreMatchers.equalTo(isLast)))
        .andExpect( jsonPath("$.hasNext", CoreMatchers.equalTo(hasNext)))
        .andExpect( jsonPath("$.hasPrevious", CoreMatchers.equalTo(hasPrevious)));
    }
}