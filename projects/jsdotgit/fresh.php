<?php
header('Content-Type: application/json');

/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

$result = $database->query("SELECT * FROM blacklisted_repos");

$blacklistedRepos = [];

while ($row = $result->fetch_assoc()) {
    $blacklistedRepos[$row['name']] = true;
}

$result = $database->query("SELECT * FROM first_time_repos WHERE first_seen_at >= CURRENT_DATE() - INTERVAL 72 HOUR");

$firstTimeRepos = [];

while ($row = $result->fetch_assoc()) {
    $firstTimeRepos[$row['name']] = true;
}

$result = $database->query("SELECT * FROM trending_repos WHERE last_seen_at >= CURRENT_DATE() - INTERVAL 1 MONTH");

$keywordsRepos = [];

$trendingRepos = [];
while ($trendingRepo = $result->fetch_assoc()) {
    $trendingRepo['metadata'] = json_decode($trendingRepo['metadata']);
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

echo json_encode($keywordsRepos['javascript']);
