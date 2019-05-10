package com.yash.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/v1/newsbit/")
public class MainController {
      @Autowired
      private CategoryService categoryService;

      @PostMapping("/getAllNews")
      public ResponseEntity<?> getAllNews(@RequestBody  List<String> categories) {
            RSSFeedParser rss=new RSSFeedParser("https://www.dnaindia.com/feeds/latest.xml");
            Feed feed=rss.readFeed();
            List<FeedMessage> entry= feed.getMessages();

            List<Category> categoryList = this.categoryService.getAllByCategory(categories);

            List<FeedMessage> feeds = this.filter(entry, categoryList);
            feeds.addAll(entry);

            return ResponseEntity.ok(feeds);
      }

      @PostMapping("/getAll")
      public ResponseEntity<?> getAllNews() {
            RSSFeedParser rss=new RSSFeedParser("https://www.dnaindia.com/feeds/latest.xml");
            Feed feed=rss.readFeed();
            List<FeedMessage> entry= feed.getMessages();

            return ResponseEntity.ok(entry);
      }

      @GetMapping("/category/all")
      public ResponseEntity<?> getAllCategories() {
            return ResponseEntity.ok(this.categoryService.getAllNames());
      }

      private List<FeedMessage> filter(List<FeedMessage> feedMessages, List<Category> categories) {
            Set<FeedMessage> filteredFeeds = new HashSet<>();
            for(FeedMessage feedMessage : feedMessages) {
                  for(Category category : categories) {

                        int index = feedMessage.title.toLowerCase().indexOf(category.getWord().toLowerCase());
                        System.out.println("word = " + category.getWord());
                        if(index >= 0) {
                              filteredFeeds.add(feedMessage);
                              break;
                        }

                        index = feedMessage.description.toLowerCase().indexOf(category.getWord().toLowerCase());
                        if(index >= 0) {
                              filteredFeeds.add(feedMessage);
                              break;
                        }

                        index = feedMessage.link.toLowerCase().indexOf(category.getWord().toLowerCase());
                        if(index >= 0) {
                              filteredFeeds.add(feedMessage);
                              break;
                        }

                        index = feedMessage.guid.toLowerCase().indexOf(category.getWord().toLowerCase());
                        if(index >= 0) {
                              filteredFeeds.add(feedMessage);
                              break;
                        }
                  }
            }

            return new ArrayList<>(filteredFeeds);
      }
}
