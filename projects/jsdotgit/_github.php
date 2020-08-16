<?php
$config = require __DIR__ . '/_config.inc.php';

$githubAccount = $config['github-accounts'][0];

$client = new \Github\Client();

$client->authenticate($githubAccount['username'], $githubAccount['password']);

return $client;
