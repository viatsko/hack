<?php
$isFresh = false;

if (strpos($_SERVER['REQUEST_URI'], 'fresh') !== false) {
    $isFresh = true;
}

$isApisPage = false;

if (strpos($_SERVER['REQUEST_URI'], 'apis') !== false) {
    $isApisPage = true;
}
?><!doctype html>
<html lang="en">
<head>
    <?php
    define('SITE_TITLE', ($isFresh ? 'FRESH ' : '' ) . 'js.git: trending javascript open source projects');
    define('SITE_DESCRIPTION', 'Follow trending javascript repositories, find out what\'s new!');
    define('SITE_MAIN_URL', 'https://jsdotgit.com/');
    define('SITE_IMAGE', 'https://jsdotgit.com/js.jpg');
    ?>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="apple-touch-icon" sizes="180x180" href="/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="/favicon-16x16.png">
    <link rel="manifest" href="/manifest.json">
    <link rel="mask-icon" href="/safari-pinned-tab.svg" color="#5bbad5">
    <meta name="theme-color" content="#ffffff">
    <title><?= SITE_TITLE ?></title>
    <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">
    <link rel="stylesheet" href="/trends.css?v20">
    <meta property="og:locale" content="en_US"/>
    <meta property="og:type" content="article"/>
    <meta property="og:title" content="<?= SITE_TITLE ?>"/>
    <meta property="og:description" content="<?= SITE_DESCRIPTION ?>"/>
    <meta property="og:url" content="<?= SITE_MAIN_URL ?>"/>
    <meta property="og:site_name" content="<?= SITE_TITLE ?>"/>
    <meta property="og:image" content="<?= SITE_IMAGE ?>"/>
    <meta property="og:image:secure_url" content="<?= SITE_IMAGE ?>"/>
    <meta property="og:image" content="<?= SITE_IMAGE ?>"/>
    <meta property="og:image:secure_url" content="<?= SITE_IMAGE ?>"/>
    <meta name="twitter:card" content="summary_large_image"/>
    <meta name="twitter:description" content="<?= SITE_DESCRIPTION ?>"/>
    <meta name="twitter:title" content="<?= SITE_TITLE ?>"/>
    <meta name="twitter:site" content="@jsdotgit"/>
    <meta name="twitter:image" content="<?= SITE_IMAGE ?>"/>
    <meta name="twitter:creator" content="@viatsko"/>
    <script async src="//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js"></script>
    <script>
        (adsbygoogle = window.adsbygoogle || []).push({
            google_ad_client: "ca-pub-6755780618217290",
            enable_page_level_ads: true
        });
    </script>
</head>
<body>
<!-- Global site tag (gtag.js) - Google Analytics -->
<script async src="https://www.googletagmanager.com/gtag/js?id=UA-110951859-1"></script>
<script>
    window.dataLayer = window.dataLayer || [];

    function gtag() {
        dataLayer.push(arguments);
    }

    gtag('js', new Date());

    gtag('config', 'UA-110951859-1');
</script>
<header class="top-bar">
    <h1 onclick="window.location = '/'" style="cursor:pointer"><img class="top-logo" src="/js-small.gif" width="64" height="64"/>.git<span class="hide-mobile">: trending javascript open source projects</span>
    </h1>
</header>
<?php
/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

$result = $database->query("SELECT * FROM blacklisted_repos");

$blacklistedRepos = [];

while ($row = $result->fetch_assoc()) {
    $blacklistedRepos[$row['name']] = true;
}

$result = $database->query("SELECT * FROM first_time_devs WHERE first_seen_at >= CURRENT_DATE() - INTERVAL 72 HOUR");

$firstTimeDevs = [];

while ($row = $result->fetch_assoc()) {
    $firstTimeDevs[$row['name']] = true;
}

$result = $database->query("SELECT * FROM trending_devs WHERE last_seen_at >= CURRENT_DATE() - INTERVAL 1 MONTH ORDER BY login ASC");

$keywordsDevs = [];

$devsMap = [];

while ($trendingDev = $result->fetch_assoc()) {
    $devsMap[$trendingDev['login']] = $trendingDev;
}

$result = $database->query("SELECT * FROM first_time_repos WHERE first_seen_at >= CURRENT_DATE() - INTERVAL 72 HOUR");

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
            $trendingRepo['badge_fresh'] = true;
        }

        $trendingDev = $devsMap[$trendingRepo['metadata']->owner->login];

        if (!empty($trendingDev) && !isset($blacklistedRepos[$trendingDev['login']])) {
            if (!isset($keywordsRepos[$trendingDev['keyword']])) {
                $keywordsDevs[$trendingDev['keyword']] = [];
            }

            if (isset($firstTimeDevs[$trendingDev['login']])) {
                $trendingDev['badge_fresh'] = true;
            }

            $trendingDev['metadata'] = json_decode($trendingDev['metadata']);

            $keywordsDevs[$trendingDev['keyword']][$trendingDev['login']] = $trendingDev;
        }

        $keywordsRepos[$trendingRepo['keyword']][] = $trendingRepo;
    }
}

function cleanupUrl($url) {
    $parse = parse_url($url);
    return $parse['host'] . ($parse['path'] !== '/' ? $parse['path'] : '');
}

function renderRepositoryFromKeywordsArray($keywords, $keyword) {
    global $isFresh;

    $list = $keywords[$keyword];

    ob_start();

    ?>
    <ul>
        <?php
        foreach ($list as $i => $repo) {
            $metadata = $repo['metadata'];

            $list[$i]['avatar'] = $metadata->owner->avatar_url;
            $list[$i]['stars'] = $metadata->stargazers_count;
            $list[$i]['forks'] = $metadata->forks_count;
            $list[$i]['homepage'] = $metadata->homepage;
            $list[$i]['description'] = $metadata->description;
        }

        foreach ($list as $i => $repo) {
            if ($isFresh && !$repo['badge_fresh']) continue;
            ?>
            <li>
                <div class="repo-card">
                    <div class="repo-card-image">
                        <a target="_blank" rel="nofollow" href="https://github.com/<?= $repo['repo_name'] ?>">
                            <img width="42" src="<?= $repo['avatar'] ?>"/>
                        </a>
                    </div>
                    <div class="repo-card-description">
                        <div>
                            <?php if ($repo['badge_fresh']): ?>
                                <span class="fresh-badge" title="'fresh' badge means that repository appeared in trends only today">fresh</span>
                            <?php endif; ?>

                            <strong>
                                <a target="_blank" rel="nofollow" class="repo-card-name"
                                   href="https://github.com/<?= $repo['repo_name'] ?>"><?= $repo['repo_name'] ?></a> ⭐<?= $repo['stars'] ?>
                            </strong>
                        </div>

                        <div style="font-size: 0.85em;color:#999">
                            forks: 🎄<?=$repo['forks'] ?> | open issues: 📮<?=$repo['metadata']->open_issues_count ?>
                            <?if (!empty($repo['metadata']->license->name) && $repo['metadata']->license->name !== 'Other'): ?>
                            | <?=$repo['metadata']->license->name ?>
                            <?endif;?>
                        </div>

                        <div class="repo-card-description-para">
                            <?= $repo['description'] ?>
                        </div>

                        <?php if (!empty($repo['homepage'])): ?>
                            <div style="font-size: 0.85em;color:#999;margin-top:10px">
                                🔗 <strong><a href="<?= $repo['homepage'] ?>" target="_blank"
                                            rel="nofollow"><?= cleanupUrl($repo['homepage']) ?></a></strong>
                            </div>
                        <?php endif; ?>

                        <?php if (isset($_GET['dev'])): ?>
                            <pre>
                                <?php print_r($repo); ?>
                            </pre>
                        <?php endif; ?>
                    </div>
                </div>
            </li>
            <?php
        }

        ?>
    </ul>
    <?php

    return ob_get_clean();
}

function renderDeveloperFromKeywordsArray($keywords, $keyword) {
    global $isFresh;

    $list = $keywords[$keyword];

    ob_start();

    ?>
    <ul>
        <?php
        foreach ($list as $i => $dev) {
            $list[$i]['avatar'] = $dev['metadata']->avatar_url;
//            $list[$i]['stars'] = $metadata->stargazers_count;
//            $list[$i]['forks'] = $metadata->forks_count;
//            $list[$i]['homepage'] = $metadata->homepage;
            $list[$i]['description'] = $dev['metadata']->bio;

            $list[$i]['type'] = $dev['metadata']->type;

//            echo '<pre>';
//            print_r($metadata);
//            echo '</pre>';
        }

//        usort($list, function ($a, $b) {
//            return $b['stars'] - $a['stars'];
//        });

        foreach ($list as $i => $dev) {
            if ($isFresh && !$dev['badge_fresh']) continue;

            ?>
            <li>
                <div class="repo-card">
                    <div class="repo-card-image">
                        <a target="_blank" rel="nofollow" href="https://github.com/<?= $dev['login'] ?>">
                            <img width="42" src="<?= $dev['avatar'] ?>"/>
                        </a>
                    </div>
                    <div class="repo-card-description">
                        <div>
                            <?php if ($dev['badge_fresh']): ?>
                                <span class="fresh-badge" title="'fresh' badge means that repository appeared in trends only today">fresh</span>
                            <?php endif; ?>

                            <strong>
                                <a target="_blank" rel="nofollow" class="repo-card-name"
                                   href="https://github.com/<?= $dev['login'] ?>"><?= $dev['login'] ?></a>
                                📦 <?=$dev['metadata']->public_repos ?> public repos
                            </strong>
                        </div>

                        <div>
                            <?php if ($dev['type'] === 'Organization'): ?>
                                <span class="organization-badge">organization</span>
                            <?php else: ?>
                                <span class="ic-badge">individual contributor</span>
                            <?php endif; ?>
                        </div>

                        <?if (isset($_GET['dev'])): ?>
                            <pre>
                                <?print_r($dev)?>
                            </pre>
                        <?endif;?>

                        <div class="repo-card-description-para">
                            <?= $dev['description'] ?>
                        </div>

                        <?php if (!empty($dev['metadata']->blog)): ?>
                            <div style="font-size: 0.85em;color:#999;margin-top:10px">
                                🔗 <strong><a href="<?= $dev['metadata']->blog ?>" target="_blank"
                                            rel="nofollow"><?= cleanupUrl($dev['metadata']->blog) ?></a></strong>
                            </div>
                        <?php endif; ?>
                    </div>
                </div>
            </li>
            <?php
        }

        ?>
    </ul>
    <?php

    return ob_get_clean();
}

?>
<main>
    <div class="container">
        <div class="row">
            <?php if ($isApisPage): ?>
                <p class="project-description">
                    While JS.git service is absolutely free, I do provide APIs support for money. Here's what you get with API support:
                </p>
                <ul>
                    <li>All monthly repos &amp; contributors feed</li>
                    <li>Fresh repos &amp; contributors feed</li>
                    <li>Access to historical trends data (starting November 2017)</li>
                </ul>
                <p class="project-description">
                    To discuss this type of partnership, please drop me a letter at <a href="mailto:viatsko@viatsko.me?subject=jsdotgit+partnership">viatsko@viatsko.me</a>
                </p>
            <?php else: ?>
                <p class="project-description">JS.git mission is to help people discover new trends in a modern open-source frontend world. We help open-source contributors and companies becoming recognized. JS.git was initially created for conferences to help with open-source awards ceremonies. Now it's used by journalists to find hidden gems and rising stars of a frontend open-source community. If you like the project, please consider <a target="_blank" href="https://twitter.com/viatsko">following my twitter for updates</a>.</p>
                <p class="project-description">Trends are being aggregated from multiple sources <strong>every hour</strong>. Project/company stays in a list as long as it's been trending for at least a day in the last month.</p>
                <ul class="view-menu">
                <?php if ($isFresh): ?>
                    <li>[ <a href="/">show currently trending repos</a> ]</li>
                    <li>[ show only fresh trending repos (72h) ]</li>
                <?php else: ?>
                    <li>[ show currently trending repos ]</li>
                    <li>[ <a href="/fresh/">show only fresh trending repos (72h)</a> ]</li>
                <?php endif; ?>
                    <li>[ <a target="_blank" href="https://twitter.com/jsdotgit">jsdotgit.com twitter</a> ]</li>
                    <li>[ <a target="_blank" href="/apis/">get apis (paid service)</a> ]</li>
                </ul>
                <table class="repo-list">
                    <tr>
                        <td>
                            <h3>Top trending repositories this month</h3>
                            <?= renderRepositoryFromKeywordsArray($keywordsRepos, 'javascript'); ?>
                        </td>
                        <td>
                            <h3>Top trending developers this month</h3>
                            <?= renderDeveloperFromKeywordsArray($keywordsDevs, 'javascript'); ?>
                        </td>
                    </tr>
                </table>
                <h2 style="text-align:center">Subscribe to our twitter feed 🔥 <a href="https://twitter.com/jsdotgit?ref_src=twsrc%5Etfw" class="twitter-follow-button" data-show-count="false">Follow @jsdotgit</a><script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>:</h2>
                <div style="margin: 0 auto; max-width: 600px">
                    <a class="twitter-timeline" data-height="500" href="https://twitter.com/jsdotgit?ref_src=twsrc%5Etfw">Tweets by jsdotgit</a> <script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>
                </div>
                <div class="total-trending">
                    Total repositories trending this month: <?= count($keywordsRepos['javascript']) ?>
                </div>
            <?php endif; ?>
        </div>
    </div>
</main>
<footer>
    &copy; <?= date('Y') ?> <a target="_blank" href="https://twitter.com/viatsko">Valerii Iatsko</a><br />
    <?php if(0):?>
    &copy; <?= date('Y') ?> Made by <a target="_blank" href="https://twitter.com/viatsko">Valerii Iatsko</a><?php if(0):?> &amp; <a
            target="_blank" href="https://twitter.com/PixelsCommander">Denis Radin</a><?php endif; ?><br/>
    <?php endif;?>
    Last update: <?= file_get_contents(__DIR__ . '/_last-updated.txt') ?>
</footer>
<a class="by-a" target="_blank" href="https://viatsko.me"><p><img src="/viatsko.png" alt="Made by viatsko" /> by viatsko</p></a>
</body>
</html>
