import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select

all_links = set()


def get_news_links(url):
    driver = webdriver.Firefox()
    driver.get(url)
    time.sleep(5)
    table = driver.find_elements(by=By.TAG_NAME, value='tbody')
    if table:
        table = table[0]
        for row in table.find_elements(by=By.TAG_NAME, value='tr'):
            link = row.find_elements(by=By.TAG_NAME, value='a')
            if link:
                all_links.add(link[0].get_attribute('href'))
    driver.quit()


def topic_selector(topic_id):
    topic_pages = set()
    # Create a new instance of the Firefox driver (you can use other drivers like Chrome, etc.)
    driver = webdriver.Firefox()

    # Open the webpage with the select element
    driver.get("https://www.allsides.com/headline-roundups")

    # Locate the select element using its ID, name, XPath, or other locators
    select_element = driver.find_elements(by=By.ID, value="edit-field-story-topic-tid")

    # Create a Select object from the select element
    select = Select(select_element[0])

    # Select the option with the value "13741"
    select.select_by_value(str(topic_id))

    apply_button = driver.find_elements(by=By.ID, value="edit-submit-allsides-story-topic-list")

    # Click the "Apply" button
    apply_button[0].click()

    time.sleep(5)

    # Alternatively, you can select by the visible text of the option
    # select.select_by_visible_text("COVID-19 Misinformation")
    # Perform any other actions you need to do on the page
    flag = 0

    table = driver.find_elements(by=By.TAG_NAME, value='tbody')
    if table:
        table = table[0]
        for row in table.find_elements(by=By.TAG_NAME, value='tr'):
            link = row.find_elements(by=By.TAG_NAME, value='a')
            if link:
                all_links.add(link[0].get_attribute('href'))

    pages = driver.find_elements(by=By.CLASS_NAME, value="pager")
    if pages:
        pages = pages[0]
        flag = 1
    if flag == 1:
        for x in pages.find_elements(by=By.XPATH, value="li"):
            a_elements = x.find_elements(By.TAG_NAME, "a")

            # Check if any <a> elements are found
            if a_elements:
                # Process the <a> elements as needed
                for a in a_elements:
                    topic_pages.add(a.get_attribute("href"))
        for x in topic_pages:
            get_news_links(x)
        time.sleep(20)
    # Close the browser window
    driver.quit()


def get_news_data(url):
    driver = webdriver.Firefox()
    text_to_return = ''
    driver.get(url)
    text = driver.find_elements(by=By.CLASS_NAME, value='article-description')
    if text:
        p_elements = text[0].find_elements(By.TAG_NAME, "p")
        for x in p_elements:
            text_to_return += x.text
        driver.quit()
        return text_to_return
    return ''


def get_l_r_c(url):
    driver = webdriver.Firefox()
    driver.get(url)
    text_to_return = ''
    featured_coverage = driver.find_elements(by=By.CLASS_NAME, value='featured-coverage')[0]
    header = driver.find_elements(by=By.CLASS_NAME, value='taxonomy-heading')[0]
    left = featured_coverage.find_elements(by=By.CLASS_NAME, value='news-item.left')
    right = featured_coverage.find_elements(by=By.CLASS_NAME, value='news-item.right')
    center = featured_coverage.find_elements(by=By.CLASS_NAME, value='news-item.center')
    if left:
        if right:
            if center:
                left_d = get_news_data(left[0].find_elements(by=By.TAG_NAME, value='a')[0].get_attribute('href'))
                center_d = get_news_data(center[0].find_elements(by=By.TAG_NAME, value='a')[0].get_attribute('href'))
                right_d = get_news_data(right[0].find_elements(by=By.TAG_NAME, value='a')[0].get_attribute('href'))
                if left_d or center_d or right_d:
                    text_to_return = text_to_return + header.text + '\n'
                    text_to_return = text_to_return + '*LEFT*' + left_d
                    text_to_return = text_to_return + '*CENTER*' + center_d
                    text_to_return = text_to_return + '*RIGHT*' + right_d
                    text_to_return = text_to_return + '\n'

    driver.quit()
    return text_to_return


if __name__ == '__main__':
    topic_id = 18969
    topic_selector(topic_id)
    with open(str(topic_id) + '.txt', 'wb') as file:
        for x in all_links:
            file.write(get_l_r_c(x).encode('utf-8'))

