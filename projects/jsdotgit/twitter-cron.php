<?php
if (empty($_GET['key']) || ($_GET['key'] !== 'BTy56PoUQ')) {
    exit;
}

error_reporting(E_ALL);

$loader = require_once __DIR__ . '/vendor/autoload.php';
$loader->add('OSSTrends', __DIR__ . '/classes/');

header('Content-Type: application/json');

/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

$result = $database->query("SELECT * FROM blacklisted_repos");

$blacklistedRepos = [];

while ($row = $result->fetch_assoc()) {
    $blacklistedRepos[$row['name']] = true;
}

$result = $database->query("SELECT * FROM first_time_repos WHERE (first_seen_at >= CURRENT_DATE() - INTERVAL 48 HOUR) AND is_twitter_shared = 0 LIMIT 1");

$firstTimeRepos = [];

while ($row = $result->fetch_assoc()) {
    $firstTimeRepos[$row['name']] = true;
}

$result = $database->query("SELECT * FROM trending_repos WHERE last_seen_at >= CURRENT_DATE() - INTERVAL 1 MONTH");

$keywordsRepos = [];

const CHINESE_JAPANESE_UTF8_REGEX = '/\p{Han}+/u';

$trendingRepos = [];
while ($trendingRepo = $result->fetch_assoc()) {
    $trendingRepo['metadata'] = json_decode($trendingRepo['metadata']);

    if (preg_match(CHINESE_JAPANESE_UTF8_REGEX, $trendingRepo['metadata']->description, $matches)) {
        continue;
    }

    $trendingRepos[] = $trendingRepo;
}

usort($trendingRepos, function ($a, $b) {
    return $b['metadata']->stargazers_count - $a['metadata']->stargazers_count;
});

foreach($trendingRepos as $trendingRepo) {
    if (!isset($blacklistedRepos[$trendingRepo['repo_name']])) {
        if (!isset($keywordsRepos[$trendingRepo['keyword']])) {
            $keywordsRepos[$trendingRepo['keyword']] = [];
        }

        if (isset($firstTimeRepos[$trendingRepo['repo_name']])) {
            $keywordsRepos[$trendingRepo['keyword']][] = $trendingRepo;
        }
    }
}

if (isset($keywordsRepos['javascript'][0])) {
    $repo = $keywordsRepos['javascript'][0];

    \Codebird\Codebird::setConsumerKey($config['twitter']['consumer_key'], $config['twitter']['consumer_secret']);

    $cb = \Codebird\Codebird::getInstance();

    $cb->setToken($config['twitter']['access_token'], $config['twitter']['access_token_secret']);

    $hashtags = [
        '#javascript',
        '#js',
        '#github'
    ];

    if (stripos($repo['metadata']->description, 'react') !== false) {
        $hashtags[] = '#react';
        $hashtags[] = '#reactjs';
    }

    if (stripos($repo['metadata']->description, 'vue') !== false) {
        $hashtags[] = '#vue';
        $hashtags[] = '#vuejs';
    }

    if (stripos($repo['metadata']->description, 'angular') !== false) {
        $hashtags[] = '#angular';
        $hashtags[] = '#angularjs';
    }

    if (stripos($repo['metadata']->description, 'ember') !== false) {
        $hashtags[] = '#ember';
        $hashtags[] = '#emberjs';
    }

    $params = array(
        'status' => '🔥 ' . $repo['metadata']->html_url . ': "' . $repo['metadata']->description . '" is trending today (' . $repo['metadata']->stargazers_count . ' ⭐️ so far) ' . join(' ', $hashtags),
    );

    $reply = $cb->statuses_update($params);

    $stmt = $database->prepare('UPDATE first_time_repos SET is_twitter_shared = 1 WHERE `name` = ?');
    $stmt->bind_param("s", $repo['repo_name']);
    $stmt->execute();

    print_r($reply);
}
