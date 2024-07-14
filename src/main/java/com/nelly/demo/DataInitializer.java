package com.nelly.demo;

import java.time.Instant;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nelly.demo.Models.Bookmark;
import com.nelly.demo.Repositories.BookmarkRepo;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

 private final BookmarkRepo repo;

 @Override
 public void run(String... args) throws Exception {
  if(repo.count() == 0){
   repo.save(new Bookmark(null, "Sivalabs", "https://sivalabs.in", Instant.now() ));
   repo.save(new Bookmark(null, "Gotcha", "https://gotcha.in", Instant.now() ));
   repo.save(new Bookmark(null, "Primack", "https://primack.in", Instant.now() ));
   repo.save(new Bookmark(null, "Groot", "https://groot.in", Instant.now() ));
   repo.save(new Bookmark(null, "GEoogle", "https://google.io", Instant.now() ));
   repo.save(new Bookmark(null, "Azure", "https://azure.in", Instant.now() ));
   repo.save(new Bookmark(null, "Digital Ocean", "https://digital-ocean.in", Instant.now() ));
   repo.save(new Bookmark(null, "Achebe", "https://achebe.in", Instant.now() ));
   repo.save(new Bookmark(null, "Fox Knox", "https://fox-nox.in", Instant.now() ));
   repo.save(new Bookmark(null, "Crime Wave", "https://crime-wave.in", Instant.now() ));
   repo.save(new Bookmark(null, "Founder Fountain", "https://founder-fountain.in", Instant.now() ));
   repo.save(new Bookmark(null, "Some Things", "https://somethings.in", Instant.now() ));
   repo.save(new Bookmark(null, "Now Way", "https://no-way.in", Instant.now() ));
  }
 }
 
}
