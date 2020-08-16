# retailcrm-moysklad-sync

Used to sync orders between [RetailCRM](https://retailcrm.ru) and [MoySklad](https://online.moysklad.ru), make sure to create config.json in resources/ directory and compile.

I didn't like the original implementation because it was too bugged and it was a head-ache to configure it.
This solution would not require any excessive configuration from you, just a few lines in config.json.

This is a non-commercial open source project, feel free to use wherever you want.

If you'll find any issues / can't find out how to use it - feel free to open an issue.

Using this on your website? Write me and I'll add you to "Production" section.

# Supported

* [x] Adding new orders from Retail CRM to Moy Sklad
* [x] Updating orders
* [x] Merge statuses of orders between RetailCRM and Moy Sklad

  Clarification - only orders in status "send-to-delivery" and "complete" will be sent to MoySklad.

# Production

* [Happy Magic](https://happymagic.ru/)

# Building

```sh
mvn package
```

# Running

```sh
/usr/bin/java -Dfile.encoding=UTF-8 -jar target/retailcrm_moysklad_sync-1.0-SNAPSHOT-jar-with-dependencies.jar > sync.log
```

# License

MIT
