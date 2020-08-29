class Solution {
  public String destCity(List<List<String>> paths) {
    Set<String> startingCities = new HashSet<>();

    for (List<String> route : paths) {
      startingCities.add(route.get(0));
    }

    for (List<String> route : paths) {
      if (!startingCities.contains(route.get(1))) {
        return route.get(1);
      }
    }

    return "";
  }
}
