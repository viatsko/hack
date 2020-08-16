import fetch from 'node-fetch';

export async function expandUrl(url: string) {
  try {
    const response = await fetch(url);

    return response.url || url;
  } catch (e) {
    return url;
  }
}
