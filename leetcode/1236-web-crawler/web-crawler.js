/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * function HtmlParser() {
 *
 *		@param {string} url
 *     	@return {string[]}
 *     	this.getUrls = function(url) {
 *      	...
 *     	};
 * };
 */

const getHost = function (url) {
  return url.split("/")[2].split(":")[0];
};

/**
 * @param {string} startUrl
 * @param {HtmlParser} htmlParser
 * @return {string[]}
 */
const crawl = function (startUrl, htmlParser) {
  const seen = new Set();
  const q = [startUrl];
  const currentHost = getHost(startUrl);

  while (q.length) {
    const url = q.pop();
    seen.add(url);

    for (const innerUrl of htmlParser.getUrls(url)) {
      if (getHost(innerUrl) === currentHost && !seen.has(innerUrl)) {
        q.push(innerUrl);
      }
    }
  }

  return [...seen];
};
