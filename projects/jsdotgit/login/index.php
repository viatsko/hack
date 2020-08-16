<?php
error_reporting(E_ALL);

ini_set('display_errors', 1);

define('OAUTH2_CLIENT_ID', '9250d78bb967dad4216f');
define('OAUTH2_CLIENT_SECRET', '621cf5b8b0d9f50204dfeacd5332c0d324d266ca');

require_once __DIR__ . '/../functions/common.php';

$authorizeURL = 'https://github.com/login/oauth/authorize';

$tokenURL = 'https://github.com/login/oauth/access_token';

$apiURLBase = 'https://api.github.com/';

session_start();

// Start the login process by sending the user to Github's authorization page
if (get('action') == 'login') {
    // Generate a random hash and store in the session for security
    $_SESSION['state'] = hash('sha256', microtime(TRUE) . rand() . $_SERVER['REMOTE_ADDR']);

    unset($_SESSION['access_token']);

    // Redirect the user to Github's authorization page
    redirect_to($authorizeURL . '?' . http_build_query([
            'client_id' => OAUTH2_CLIENT_ID,
            'redirect_uri' => "https://jsdotgit.com/login/",
            'state' => $_SESSION['state'],
            'scope' => 'user:email'
        ]));
}

// When Github redirects the user back here, there will be a "code" and "state" parameter in the query string
if (get('code')) {
    // Verify the state matches our stored state
    if (!get('state') || $_SESSION['state'] != get('state')) {
        redirect_to($_SERVER['PHP_SELF']);
    }

    // Exchange the auth code for a token
    $token = apiRequest($tokenURL . '?' . http_build_query([
            'client_id' => OAUTH2_CLIENT_ID,
            'client_secret' => OAUTH2_CLIENT_SECRET,
            'state' => session('state'),
            'code' => get('code')
        ]));

    $_SESSION['access_token'] = $token->access_token;

    redirect_to('/login/');
}
if (session('access_token')) {
    $user = apiRequest($apiURLBase . 'user?access_token=' . session('access_token'));

    if (!empty($user) && $user->login === 'viatsko') {
        $_SESSION['isAdmin'] = true;
        redirect_to('/admin/');
    } else {
        redirect_to('/');
    }
} else {
    echo '<p><a href="?action=login">Log In</a></p>';
}

function apiRequest($url) {
    $context = stream_context_create([
        'http' => [
            'user_agent' => 'CWestify GitHub OAuth Login',
            'header' => 'Accept: application/json'
        ]
    ]);
    $response = @file_get_contents($url, false, $context);
    return $response ? json_decode($response) : $response;
}

function get($key, $default = NULL) {
    return isset($_GET[$key]) ? $_GET[$key] : $default;
}

function session($key, $default = NULL) {
    return isset($_SESSION[$key]) ? $_SESSION[$key] : $default;
}

