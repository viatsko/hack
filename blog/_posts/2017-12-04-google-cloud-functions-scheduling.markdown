---
layout: post
title:  "Google Cloud Functions: Scheduling"
date:   2017-12-04 09:00:18 +0200
categories: gcp
---

In a previous article, I've explained 5 easy steps to deploy Google Cloud Function. In this article, I’ll explain how to set up cron for it on Google Cloud Standard App Engine Platform.

The problem is that NodeJS is only available on App Engine Flexible, but it doesn’t make sense to set up flexible instance just for kicking GCF with cron.

Instead, we can create a simple python app and deploy it on App Engine Standard Platform.

We’ll need to add 3 files to the application:

app.yaml

{% highlight yaml %}
runtime: python27
api_version: 1
threadsafe: true
handlers:
- url: /.*
  script: main.app
skip_files:
- ^node_modules/.*
{% endhighlight %}

cron.yaml

{% highlight yaml %}
cron:
- description: "regular job"
  url: /hourly
  schedule: every 1 hours
{% endhighlight %}

main.py

{% highlight python %}
import webapp2
import urllib2

class HourlyCronPage(webapp2.RequestHandler):
    def get(self):
        response = urllib2.urlopen('<url_of_your_cloud_function>')

self.response.write(response.read())

app = webapp2.WSGIApplication([
    ('/hourly', HourlyCronPage),
], debug=True)
{% endhighlight %}

After creating these files, steps to deploy a cronjob runner are as follow:

```
gcloud app deploy
gcloud app deploy cron.yaml
```

Enjoy!
