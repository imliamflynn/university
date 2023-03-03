x = input("Enter a web address: ")
import urllib.request
file = urllib.request.urlopen(x)
page = file.read()
page_string = page.decode("utf-8")
words = page_string.split()
words2 = page_string.split('"')
for word in words2:
    if "http://" in word or "https://" in word:
        print(word)