from flask import Flask, request
import urllib.request
import re

app = Flask(__name__)
app.debug = True

@app.route('/')
@app.route('/search')
@app.route('/webhp')
def index():
    query = request.args.get('q')

    if query == "facebook":
        url = 'http://173.194.32.247/search?q=katzenbabys'
        a = urllib.request.urlopen(getRequest(url))
        return doMagic(a.readall().decode('utf-8'))

    if query:
        url = 'http://173.194.32.247/search?q=%s' % (query.replace(" ", "+"),)
        a = urllib.request.urlopen(getRequest(url))
        return doMagic(a.readall().decode('utf-8'))

    resource = urllib.request.urlopen('http://173.194.32.247/')
    content = resource.read().decode(resource.headers.get_content_charset())
    return re.sub('action="[^"]+','action="/', content)

## replace https with http to force a plain request
#
def doMagic(content):
        body = re.sub('href="https:', 'href="http:', content)
        return body

## set user agent
#
def getRequest( url ):
     req = urllib.request.Request(url,data=None,
        headers={'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36'})
     return req

if __name__ == '__main__':
    app.run(host='0.0.0.0')
