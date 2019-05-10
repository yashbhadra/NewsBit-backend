package com.yash.demo;

import java.util.ArrayList;
import java.util.List;

public class FilterRss extends FeedMessage {
    List<String> category;
    FilterRss(ArrayList<String> categoryOfNews) {
        category=categoryOfNews;
    }

        public List getAllNews()
        {
            RSSFeedParser rss = new RSSFeedParser("https://www.dnaindia.com/feeds/latest.xml");
            Feed feed = rss.readFeed();
            List<FeedMessage> entry = feed.getMessages();
            return entry;
        }
        public List filteredNews()
        {
            RSSFeedParser rss = new RSSFeedParser("https://www.dnaindia.com/feeds/latest.xml");
            Feed feed = rss.readFeed();
            List<FeedMessage> entry = feed.getMessages();



            return
        }




}
