package com.yash.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/newsbit/")
public class MainController {
      @GetMapping("/getAllNews")
      public ResponseEntity<?> getAllNews() {
            RSSFeedParser rss=new RSSFeedParser("https://www.dnaindia.com/feeds/latest.xml");
            Feed feed=rss.readFeed();
            List<FeedMessage> entry= feed.getMessages();
            return ResponseEntity.ok(entry);
      }
}
