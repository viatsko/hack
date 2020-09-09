function compareVersion(version1: string, version2: string): number {
  const version1Split = version1.split(".");
  const version2Split = version2.split(".");

  for (
    let i = 0;
    i < Math.max(version1Split.length, version2Split.length);
    i++
  ) {
    const version1Part = version1Split[i] ? parseInt(version1Split[i], 10) : 0;
    const version2Part = version2Split[i] ? parseInt(version2Split[i], 10) : 0;

    if (version1Part > version2Part) {
      return 1;
    } else if (version1Part < version2Part) {
      return -1;
    }
  }

  return 0;
}
