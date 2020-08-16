---
layout: post
title:  "Deploying Google Cloud Functions"
date:   2017-12-04 09:00:18 +0200
categories: gcp
---

As I'm constantly forgetting how to do it on every new project I create, here's the summary.

First, you need a project to be created already. If not, go to [https://console.cloud.google.com](https://console.cloud.google.com) and create it. You also need to visit Google Cloud Functions section at least once to make sure GCF API is enabled. You’ll also need to create a storage bucket for a function — there’s no rocket science there, just pick up random name 👍

Second, you need to have Google Cloud SDK installed on your machine. You can download it from here or just go with brew:

```
brew cask install google-cloud-sdk
```

Third, you need to set the current project for Google Cloud SDK. The directory structure doesn’t need to be there yet.

```
gcloud auth login
gcloud config set project <project_name>
```

Forth step! We need a nodejs project set up. It’s enough to just do yarn init in a desired project and create index.js with a content of your new cloud function, like this:

```
exports.fetch = function(req, res) { res.send('Hello, world!'); }
```

Final step 🎉

```
gcloud beta functions deploy <your_function_name> --entry-point=<your_entry_point_name_exported_by_index.js> --trigger-http --stage-bucket=<your_stage_bucket>
```

Example:

```
gcloud beta functions deploy react-server-side-rendering-service --entry-point=render --trigger-http --stage-bucket=my-awesome-startup-gcf-bucket
```

That’s it! 😎

This article is also published on Medium in [Google Cloud Platform - Community](https://medium.com/google-cloud/deploying-google-cloud-functions-in-5-easy-steps-21f6d837c6bb)
