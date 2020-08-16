import * as React from "react";
import { RedditItem } from "../../@types";
import { Subject } from "../subject/Subject";
import makeStyles from "@material-ui/core/styles/makeStyles";
import { default as MaterialUICard } from "@material-ui/core/Card";
import { getRelativeTimestamp } from "../../utils/getRelativeTimestamp";

interface Props {
  redditItems: RedditItem[];
}

const useStyles = makeStyles((theme) => ({
  item: {
    //marginBottom: theme.spacing(5),
  },
  image: {
    maxWidth: "100%",
    //marginTop: theme.spacing(1),
  },
  root: {
    padding: theme.spacing(2),
    marginBottom: theme.spacing(2),
    "& a": {
      color: "inherit",
      fontWeight: "bold",
    },
  },
  title: {
    marginBottom: theme.spacing(1),
  },
  grid: {
    display: "grid",
    gridGap: "16px",
    gridTemplateColumns: "repeat(3, 1fr)",
  },
}));

function htmlDecode(input: string) {
  const e = document.createElement("textarea");
  e.innerHTML = input;
  // handle case of empty input
  return e.childNodes.length === 0 ? "" : e.childNodes[0].nodeValue;
}

export function RedditFeed(props: Props): JSX.Element {
  const styles = useStyles();

  const [showText, setShowText] = React.useState(false);

  React.useEffect(() => {
    setShowText(true);
  }, []);

  return (
    <div className={styles.grid}>
      {props.redditItems.map((redditItem, index) => {
        return (
          <MaterialUICard className={styles.root} key={`reddit-item-${index}`}>
            <div className={styles.item}>
              {getRelativeTimestamp(
                new Date(+(redditItem.created_utc || 0) * 1000)
              )}
              <div className={styles.title}>
                <Subject
                  title={redditItem.title}
                  url={`https://reddit.com${redditItem.permalink}`}
                  noCut={true}
                  bigger
                />
              </div>
              {redditItem.thumbnail &&
                redditItem.thumbnail !== "self" &&
                redditItem.thumbnail !== "default" && (
                  <a
                    href={`https://reddit.com${redditItem.permalink}`}
                    target="_blank"
                  >
                    <img
                      className={styles.image}
                      src={
                        redditItem.preview?.images?.[0]?.source?.url?.replace(
                          /\&amp\;/g,
                          "&"
                        ) || redditItem.thumbnail
                      }
                    />
                  </a>
                )}
              {showText && redditItem.selftext_html && (
                <p
                  style={{ marginTop: 0 }}
                  dangerouslySetInnerHTML={{
                    __html: `${htmlDecode(redditItem.selftext_html)}`,
                  }}
                ></p>
              )}
            </div>
          </MaterialUICard>
        );
      })}
    </div>
  );
}
