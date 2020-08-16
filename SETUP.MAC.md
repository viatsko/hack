# Mac

Setting keyboard speed to maximum (you can't do this via System Preferences, these are below allowed minimums).

```
defaults write -g InitialKeyRepeat -int 10
defaults write -g KeyRepeat -int 1
```

You'll need relog after changing these.
