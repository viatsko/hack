for word in `cat words.txt`; do echo $word; done | sort | uniq -c | sort -r | awk '{print $2, $1}'
