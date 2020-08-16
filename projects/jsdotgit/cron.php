<?php
if (empty($_GET['key']) || ($_GET['key'] !== 'BTy56PoUQ')) {
    exit;
}

error_reporting(E_ALL);

ini_set('display_errors', 1);

$loader = require_once __DIR__ . '/vendor/autoload.php';
$loader->add('OSSTrends', __DIR__ . '/classes/');

$config = require(__DIR__ . '/_config.inc.php');

/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

/** @var Github\Client $client */
$client = require(__DIR__ . '/_github.php');

$keywords = $config['github-keywords'];

$time = time();

$date = date('Y-m-d h:i:s', $time);

$dateYMD = date('Y-m-d', strtotime('-30 days'));

foreach($keywords as $keyword) {
    $trendingDevelopers = \OSSTrends\GithubTrends::getTrendingDevelopersByKeyword($keyword);

    $trendingRepos = \OSSTrends\GithubTrends::getTrendingRepositoriesByKeyword($keyword);

    foreach($trendingRepos as $trendingRepo) {
        list($username, $repository) = explode('/', $trendingRepo);
        $repo = $client->repository()->show($username, $repository);

//        if ($repo['stargazers_count'] < 100) {
//            continue;
//        }

        $trendingDevelopers[] = $repo['owner']['login'];

        $stmt = $database->prepare('DELETE FROM trending_repos WHERE repo_name = ? AND keyword = ?');
        $stmt->bind_param("ss", $trendingRepo, $keyword);
        $stmt->execute();

        $metadata = json_encode($repo, JSON_UNESCAPED_UNICODE);

        $stmt = $database->prepare('INSERT INTO trending_repos(repo_name, keyword, metadata, last_seen_at) VALUES (?,?,?,?)');
        $stmt->bind_param("ssss", $trendingRepo, $keyword, $metadata, $date);
        $stmt->execute();

        $stmt = $database->prepare('INSERT IGNORE INTO first_time_repos(`name`,first_seen_at) VALUES (?,?)');
        $stmt->bind_param("ss", $trendingRepo, $date);
        $stmt->execute();
    }

    $searchClient = $client->search();

    $searchClient->setPerPage(100);

    $starredReposResponse = $searchClient->repositories(
        'language:javascript created:>=' . $dateYMD,
        'stargazers_count',
        'desc'
    );

    $starredRepos = $starredReposResponse['items'];

//    echo '<pre>';
//    print_r($starredRepos);
//    echo '</pre>';

    foreach($starredRepos as $starredRepo) {
        if ($starredRepo['stargazers_count'] < 100) {
            continue;
        }

        $stmt = $database->prepare('DELETE FROM trending_repos WHERE repo_name = ? AND keyword = ?');
        $stmt->bind_param("ss", $starredRepo['full_name'], $keyword);
        $stmt->execute();

        $metadata = json_encode($starredRepo, JSON_UNESCAPED_UNICODE);

        $trendingDevelopers[] = $starredRepo['owner']['login'];

        $stmt = $database->prepare('INSERT INTO trending_repos(repo_name, keyword, metadata, last_seen_at) VALUES (?,?,?,?)');
        $stmt->bind_param("ssss", $starredRepo['full_name'], $keyword, $metadata, $date);
        $stmt->execute();

        $stmt = $database->prepare('INSERT IGNORE INTO first_time_repos(`name`,first_seen_at) VALUES (?,?)');
        $stmt->bind_param("ss", $starredRepo['full_name'], $date);
        $stmt->execute();
    }

    foreach($trendingDevelopers as $trendingDeveloper) {
        try {
            $developer = $client->user()->show($trendingDeveloper);

            $stmt = $database->prepare('DELETE FROM trending_devs WHERE login = ? AND keyword = ?');
            $stmt->bind_param("ss", $trendingDeveloper, $keyword);
            $stmt->execute();

            $metadata = json_encode($developer, JSON_UNESCAPED_UNICODE);

            $stmt = $database->prepare('INSERT INTO trending_devs(login, keyword, metadata, last_seen_at) VALUES (?,?,?,?)');
            $stmt->bind_param("ssss", $trendingDeveloper, $keyword, $metadata, $date);
            $stmt->execute();

            $stmt = $database->prepare('INSERT IGNORE INTO first_time_devs(`name`,first_seen_at) VALUES (?,?)');
            $stmt->bind_param("ss", $trendingDeveloper, $date);
            $stmt->execute();
        } catch (Exception $e) {

        }
    }
}

file_put_contents(__DIR__ . '/_last-updated.txt', date('m/d/Y h:i:s'));

echo 'Done.';
