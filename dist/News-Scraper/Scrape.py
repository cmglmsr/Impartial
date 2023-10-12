import requests
import re
import urllib
from urllib import parse
from bs4 import BeautifulSoup


class Scraper:
    def __init__(self, url1, url2):
        self.politics_articles_dict = {}
        self.world_articles_dict = {}
        self.url1 = url1
        self.url2 = url2

    def extract_politics_articles(self):
        resp = requests.get(self.url1)
        parsed_resp = BeautifulSoup(resp.content, 'html.parser')
        articles = parsed_resp.findAll("article")
        for article in articles:
            self.politics_articles_dict[article.find(class_='story-title').text.strip()] = article.find("p").text.strip()
        return parsed_resp.findAll("article")

    def extract_world_articles(self):
        resp = requests.get(self.url2)
        parsed_resp = BeautifulSoup(resp.content, 'html.parser')
        lis = parsed_resp.findAll("li", class_="story-collection__story__LeZ29 story-collection__default__G33_I story-collection__with-spacing__1E6N5") + \
              parsed_resp.findAll(class_="story-collection__hero__2gK6- story-collection__default__G33_I story-collection__with-spacing__1E6N5")
        for li in lis:
            self.world_articles_dict[li.find("a", "text__text__1FZLe text__dark-grey__3Ml43 text__inherit-font__1Y8w3 text__inherit-size__1DZJi link__underline_on_hover__2zGL4 media-story-card__heading__eqhp9").text.strip()] \
            = "1"

    def print_politics_articles(self):
        for key in self.politics_articles_dict.keys():
            print(key + " -> " + self.politics_articles_dict[key])

    def print_world_articles(self):
        for key in self.world_articles_dict.keys():
            print(key + " -> " + self.world_articles_dict[key])


URL1 = "https://www.reuters.com/news/archive/politicsNews"
URL2 = "https://www.reuters.com/world/us/"
sc = Scraper(URL1, URL2)
sc.extract_politics_articles()
sc.extract_world_articles()
sc.print_world_articles()

