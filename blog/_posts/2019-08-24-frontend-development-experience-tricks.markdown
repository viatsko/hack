---
layout: post
title:  "Frontend Development Experience Tricks"
date:   2019-08-24 09:00:18 +0200
categories: frontend
---

# 1. Prevent `node_modules` from being indexed

This is a single thing which slows Mac down by tons, especially if you're on a corporate laptop with paranoidal-level security settings.

```
...
"postinstall": "touch ./.metadata_never_index"
...
```

# 2. Speed up TSC and lower it's memory consumption.

This can be achieved by enabling TSC_WATCHFILE option with `UseFsEventsWithFallbackDynamicPolling` set.

```
export TSC_WATCHFILE="UseFsEventsWithFallbackDynamicPolling"
```
