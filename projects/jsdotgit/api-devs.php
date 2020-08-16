<?php
header('Content-Type: application/json');

/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

$result = $database->query("SELECT * FROM blacklisted_repos");

$blacklistedDevs = [];

while ($row = $result->fetch_assoc()) {
    $blacklistedDevs[$row['name']] = true;
}

$result = $database->query("SELECT * FROM first_time_devs WHERE first_seen_at >= CURRENT_DATE() - INTERVAL 48 HOUR");

$firstTimeDevs = [];

while ($row = $result->fetch_assoc()) {
    $firstTimeDevs[$row['name']] = true;
}

$result = $database->query("SELECT * FROM trending_devs WHERE last_seen_at >= CURRENT_DATE() - INTERVAL 1 MONTH ORDER BY login ASC");

$keywordsDevs = [];

const CHINESE_JAPANESE_UTF8_REGEX = '/\p{Han}+/u';

$trendingDevs = [];
while ($trendingDev = $result->fetch_assoc()) {
    $trendingDev['metadata'] = json_decode($trendingDev['metadata']);

    if (preg_match(CHINESE_JAPANESE_UTF8_REGEX, $trendingDev['metadata']->description, $matches)) {
        continue;
    }

    $trendingDevs[] = $trendingDev;
}

usort($trendingDevs, function ($a, $b) {
    return $b['metadata']->followers - $a['metadata']->followers;
});

foreach($trendingDevs as $trendingDev) {
    if (!isset($blacklistedDevs[$trendingDev['login']])) {
        if (!isset($keywordsDevs[$trendingDev['keyword']])) {
            $keywordsDevs[$trendingDev['keyword']] = [];
        }

        if (isset($_GET['all']) || isset($firstTimeDevs[$trendingDev['login']])) {
            $keywordsDevs[$trendingDev['keyword']][] = $trendingDev;
        }
    }
}

if (isset($_GET['all'])) {
    echo json_encode($keywordsDevs['javascript']);
} else {
    echo json_encode(array_slice($keywordsDevs['javascript'], 0, 10));
}
