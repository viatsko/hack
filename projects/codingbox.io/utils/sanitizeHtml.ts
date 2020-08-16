import sanitizeHtmlBase from "sanitize-html";

export function sanitizeHtml(dirty: string | null): string {
  if (!dirty) {
    return "";
  }

  return sanitizeHtmlBase(dirty, {
    allowedTags: sanitizeHtmlBase.defaults.allowedTags.concat(["img"]),
  });
}
