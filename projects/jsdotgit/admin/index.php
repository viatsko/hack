<?php
error_reporting(E_ALL);

ini_set('display_errors', 1);

require_once __DIR__ . '/../functions/common.php';

/** @var mysqli $database */
$database = require __DIR__ . '/../_database.php';

session_start();

if (empty($_SESSION['isAdmin'])) {
    redirect_to('/');
}
?>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin</title>
</head>
<body>
<h2>Admin</h2>
<form action="/admin/?action=blacklist" method="post">
    <p>
        Blacklist repo:<br />
        <input type="text" name="repoName" />
    </p>
    <p>
        <input type="submit" value="Add" />
    </p>
    <?php
        if (isset($_GET['action']) && $_GET['action'] === 'blacklist') {
            $repoName = trim(@$_POST['repoName']);

            $stmt = $database->prepare("INSERT INTO blacklisted_repos(name) VALUES(?)");
            $stmt->bind_param("s", $repoName);
            $stmt->execute();
        }

        if (isset($_GET['action']) && $_GET['action'] === 'blacklist_delete') {
            $stmt = $database->prepare("DELETE FROM blacklisted_repos WHERE `name` = ?");
            $stmt->bind_param("s", $_GET['name']);
            $stmt->execute();
        }

        $result = $database->query("SELECT * FROM blacklisted_repos");

        $blacklistedRepos = [];

        while($row = $result->fetch_assoc()) {
            $blacklistedRepos[] = $row;
        }
    ?>
    <h3>Blacklisted repos</h3>
    <ul>
        <?php foreach($blacklistedRepos as $blacklistedRepo): ?>
            <li><?= $blacklistedRepo['name'] ?> <a href="/admin/?action=blacklist_delete&name=<?= urlencode($blacklistedRepo['name']) ?>">delete</a></li>
        <?php endforeach; ?>
    </ul>
</form>
</body>
</html>
