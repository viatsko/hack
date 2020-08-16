<?php
$config = require(__DIR__ . '/_config.inc.php');

$mysqli = new mysqli(
    $config['database']['hostname'],
    $config['database']['username'],
    $config['database']['password'],
    $config['database']['database']
);

if ($mysqli->connect_errno) {
    echo "Failed to connect to MySQL: " . $mysqli->connect_error;
}

$mysqli->query("SET NAMES utf8mb4");

return $mysqli;
