<?php
function redirect_to($url) {
    header('Location: ' . $url);
    exit;
}
