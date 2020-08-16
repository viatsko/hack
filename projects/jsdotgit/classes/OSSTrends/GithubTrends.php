<?php
/**
 * Created by IntelliJ IDEA.
 * User: viatsko
 * Date: 09/12/2017
 * Time: 17:52
 */

namespace OSSTrends;

require_once __DIR__ . '/../../functions/selector.php';

class GithubTrends {
    public static function getTrendingDevelopersByKeyword($keyword) {
        $url = 'https://github.com/trending/developers/' . $keyword;

        $contents = file_get_contents($url);

        $dom = new \SelectorDOM($contents);

        $developersElement = $dom->select('.explore-content h2 a');

        $developersNames = [];

        foreach ($developersElement as $developerElement) {
            $developerName = substr($developerElement['attributes']['href'], 1);

            $developersNames[] = $developerName;
        }

        return $developersNames;
    }

    public static function getTrendingRepositoriesByKeyword($keyword) {
        $url = 'https://github.com/trending/' . $keyword;

        $contents = file_get_contents($url);

        $dom = new \SelectorDOM($contents);

        $repositoriesElements = $dom->select('ol.repo-list h3 a');

        $repositoriesNames = [];

        foreach ($repositoriesElements as $repositoryElement) {
            $repositoryName = substr($repositoryElement['attributes']['href'], 1);

            $repositoriesNames[] = $repositoryName;
        }

        return $repositoriesNames;
    }
}
