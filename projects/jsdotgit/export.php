<?php
header('Content-Type: application/json');

/** @var mysqli $database */
$database = require(__DIR__ . '/_database.php');

$result = $database->query("SELECT * FROM trending_repos");

$main_data_flat = array();
function flatten($data, $parent = "") {
    global $main_data_flat;

    if ($parent === "") {
        $main_data_flat = [];
    }

    $out = array();
    foreach( $data as $k => $v ) {
        $chain = ($parent === '' ? '' : $parent . ".") . $k;
        if( is_array($v) ) {
            $out = array_merge($out, flatten($v, $chain));
        } else {
            $out[$chain] = $v;
            $main_data_flat[$chain] = $v;
        }
    }
    return($out);
}

$rows = [];

while ($repo = $result->fetch_assoc()) {
    $metadata = flatten(json_decode($repo['metadata'], JSON_OBJECT_AS_ARRAY));
    $metadata['last_seen_at'] = $repo['last_seen_at'];
    $rows[] = $metadata;
}

function generateCsv($data, $delimiter = ',', $enclosure = '"') {
    $contents = '';
    $handle = fopen('php://temp', 'r+');
    fputcsv($handle, array_keys($data[0]), $delimiter, $enclosure);
    foreach ($data as $line) {
        fputcsv($handle, $line, $delimiter, $enclosure);
    }
    rewind($handle);
    while (!feof($handle)) {
        $contents .= fread($handle, 8192);
    }
    fclose($handle);
    return $contents;
}

echo generateCsv($rows);
