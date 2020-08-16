const fs = require('fs');
const http = require('http');
const path = require('path')
const electron = require('electron');
const { app, Menu, Tray, BrowserWindow, MenuItem } = require('electron');
const request = require('request');
const url = require('url');

const { downloadImages } = require('./earthporn');
const { ensureExists, getUserHome } = require('./utils');

let trayIcon = null;
let window = null;

const TRAY_ARROW_HEIGHT = 50;
const WINDOW_WIDTH = 600;
const WINDOW_HEIGHT = 400;
const HORIZ_PADDING = 15;
const VERT_PADDING = 15;

const WALLPAPERS_PATH = path.join(getUserHome(), 'Pictures', 'EarthWallpapers');

function processPicture(pictureUrl) {
  return new Promise((resolve, reject) => {
    const pictureName = path.basename(url.parse(pictureUrl).pathname);
    const pictureFileName = path.join(WALLPAPERS_PATH, pictureName);

    fs.stat(pictureFileName, (err, stats) => {
      if (err && err.code) {
        request.get(pictureUrl).pipe(fs.createWriteStream(pictureFileName));
      }
    });
  });
}

function downloadTimerTick() {
  ensureExists(WALLPAPERS_PATH).then(() => {
    downloadImages().then((pictures) => {
      pictures.forEach(processPicture);
    });

    setTimeout(downloadTimerTick, 3600);
  });
}

downloadTimerTick();

app.on('ready', function() {
  
  if(process.platform === 'darwin') app.dock.hide();

  window = new BrowserWindow({
    width: WINDOW_WIDTH,
    height: WINDOW_HEIGHT,
    resizable: false,
    frame: false,
    transparent: true,
    show: false
  });

  window.loadURL('file://' + __dirname + '/index.html');

  window.on('close', function () {
    window = null;
  });

  window.on('blur', function(){
    window.hide();
  });

  const handleRedirect = (e, url) => {
    if(url != window.webContents.getURL()) {
      e.preventDefault()
      require('electron').shell.openExternal(url);
    }
  }
  
  window.webContents.on('will-navigate', handleRedirect);
  window.webContents.on('new-window', handleRedirect);

  const iconName = 'images/icon.png';
  const iconPath = path.join(__dirname, iconName);

  trayIcon = new Tray(iconPath);
  trayIcon.setToolTip('Hello World');

  trayIcon.on('click', (event) => {
    var screen = electron.screen;
    const cursorPosition = screen.getCursorScreenPoint();
    const primarySize = screen.getPrimaryDisplay().workAreaSize;
    const trayPositionVert = cursorPosition.y >= primarySize.height/2 ? 'bottom' : 'top';  
    const trayPositionHoriz = cursorPosition.x >= primarySize.width/2 ? 'right' : 'left';  
    window.setPosition(getTrayPosX(),  getTrayPosY());
    window.isVisible() ? window.hide() : window.show();

    function getTrayPosX() {
      const horizBounds = {
        left:   cursorPosition.x - WINDOW_WIDTH/2,
        right:  cursorPosition.x + WINDOW_WIDTH/2
      }
      if (trayPositionHoriz == 'left') {
        return horizBounds.left <= HORIZ_PADDING ? HORIZ_PADDING : horizBounds.left;
      }
      else {
        return horizBounds.right >= primarySize.width ? primarySize.width - HORIZ_PADDING - WINDOW_WIDTH: horizBounds.right - WINDOW_WIDTH;
      }
    }    
    function getTrayPosY() {
      return trayPositionVert == 'bottom' ? cursorPosition.y - WINDOW_HEIGHT - VERT_PADDING : cursorPosition.y + VERT_PADDING;
    }
  });

  var menu = new Menu();

  menu.append(new MenuItem({ label: 'Quit', click: () => app.quit() }));

  var ipcMain = require('electron').ipcMain;
  ipcMain.on('show-config-menu', (event) => {
      menu.popup(window);
  });

});
