# underhood

## Про Букинг

* Интервью с CTO "How to Build a Kick-Ass Company Culture, with Brendan Bank of Booking.com" http://linkhumans.com/podcast/brendan-bank-booking

## Про deployments в крупных компаниях

* Подход Facebook http://arstechnica.com/business/2012/04/exclusive-a-behind-the-scenes-look-at-facebook-release-engineering/

## Про Atom

### Мои пакеты (исключая корпоративные)

```
├── advanced-new-file@0.5.0
├── blame@0.9.0
├── clipboard-plus@0.5.1
├── color-picker@2.0.14
├── cursor-history@0.5.9
├── emmet@2.3.17
├── git-grep-provider@0.9.0
├── git-plus@5.7.1
├── highlight-selected@0.11.1
├── language-babel@2.6.2
├── linter@1.11.3
├── linter-eslint@5.2.6
├── merge-conflicts@1.3.7
├── nuclide-fuzzy-filename-provider@0.0.35
├── nuclide-health@0.0.35
├── nuclide-open-filenames-provider@0.0.35
├── nuclide-quick-open@0.0.35
├── nuclide-recent-files-provider@0.0.35
├── pigments@0.19.3
└── remote-sync@3.5.0
```

### Nuclide Quick Open (OmniSearch, он же Cmd+T, я им заменяю Cmd+P в Atom в keybindings)

<img src="http://i.imgur.com/2cbhrCQ.png" />

```sh
brew install watchman
apm install nuclide-quick-open nuclide-fuzzy-filename-provider
```

Если нужен git-grep, как на скриншоте, ищет через `git grep --cached` (может подойти не всем, но попоробовать советую):

```sh
apm install git-grep-provider
```

Перевесить Cmd+P на File Names поиск в OmniSearch легко! Нужно добавить в бинды:

```
'.platform-darwin atom-workspace':
  'cmd-p': 'nuclide-fuzzy-filename-provider:toggle-provider'
```

### Мой конфиг

```
"*":
  core:
    audioBeep: false
    followSymlinks: true
    ignoredNames: [
      ".git"
      ".hg"
      ".svn"
      ".DS_Store"
      ".keep"
      "._*"
      "*.pyc"
      "Thumbs.db"
    ]
  editor:
    fontFamily: "Hack"
    fontSize: 12
    invisibles:
      cr: "↩"
      eol: " "
      tab: "⇥"
    preferredLineLength: 120
    scrollPastEnd: false
    showIndentGuide: true
    showInvisibles: true
    tabType: "soft"
  "language-babel": {}
  linter:
    lintOnFly: true
    showErrorPanel: false
    showErrorTabFile: false
    showErrorTabProject: false
    statusIconPosition: "Right"
  "nuclide-health": {}
  "one-dark-ui":
    layoutMode: "Compact"
  "status-bar":
    cursorPositionFormat: "L:%L C:%C"
  tabs:
    enableVcsColoring: true
  "tree-view":
    hideIgnoredNames: true
    hideVcsIgnoredFiles: true
    squashDirectoryNames: true
  welcome:
    showOnStartup: false
".babel.regexp.source":
  editor:
    preferredLineLength: 120
".js.jsx.source":
  editor:
    preferredLineLength: 120
```

### Патченная версия Atom

Если у вас большой git-репозиторий и Atom крешится на нем, патч для libgit2, работаю над PR в libgit2. Собирается раз в неделю из git'а Atom.

Для Mac'а:

https://drive.google.com/file/d/0Bz_tlD3Uxrz2X1NkdFp5SVgxZ1E/view?usp=sharing
