from flask import Flask, request
import urllib.request
import re

app = Flask(__name__)
app.debug = True

@app.route('/')
@app.route('/search')
def index():
    query = request.args.get('q')

    if query:
        #build url from query to nosslgoogle
        url = 'http://216.239.32.20/search?q=%s' % (query,)

        a = urllib.request.urlopen(getRequest(url))

        return setFacebookFoobar(a.readall().decode('utf-8'))

    #if there is no argument q, deliver main page
    return urllib.request.urlopen('http://216.239.32.20/').readall()

def setFacebookFoobar(content):
        body = re.sub('[Ff]acebook', 'foobar', content)
        return body


def getRequest( url ):
     # fake user agent to prevent 403
     req = urllib.request.Request(
        url,
        data=None,
        headers={
           'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2227.0 Safari/537.36'
        }
     )
     return req

def getimages():
    return urllib.request.urlopen('http://216.239.32.20' + request.path).readall()


if __name__ == '__main__':
    app.run(host='0.0.0.0')
