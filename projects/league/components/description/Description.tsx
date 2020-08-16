import * as React from "react";
import Typography from "@material-ui/core/Typography";
import { makeStyles } from "@material-ui/core/styles";
import classNames from "classnames";
import KeyboardArrowDownIcon from "@material-ui/icons/KeyboardArrowDown";
import KeyboardArrowUpIcon from "@material-ui/icons/KeyboardArrowUp";
import Button from "@material-ui/core/Button";
import { useInView } from "../../hooks/useInView";

const FOLDING_THRESHOLD = 400;

interface Props {
  description: string;
  shouldFold?: boolean;
}

const useStyles = makeStyles(() => ({
  description: {
    transition: "max-height 1s ease-in",
    wordBreak: "break-word",
    // maxHeight: 130,
    // overflow: "hidden",
    // textOverflow: "ellipsis",
  },
  descriptionFolded: {
    transition: "max-height 1s ease-in",
    maxHeight: FOLDING_THRESHOLD,
    overflow: "hidden",
    position: "relative",
    "&:after": {
      content: "''",
      zIndex: 1,
      position: "absolute",
      top: 0,
      left: 0,
      right: 0,
      bottom: 0,
      background:
        "linear-gradient(180deg, rgba(2,0,36,0) 0%, rgba(9,9,121,0) 87%, rgba(255,255,255,1) 100%)",
    },
  },
  buttonContainer: {
    display: "flex",
    alignItems: "center",
  },
  button: {
    flex: 1,
  },
}));

export function Description(props: Props): JSX.Element {
  const classes = useStyles();

  const [isFoldable, setFoldable] = React.useState(Boolean(props.shouldFold));
  const [isFolded, setFolded] = React.useState(Boolean(props.shouldFold));

  const descriptionRef = React.useRef<HTMLDivElement>(null);

  const [ref, isVisible] = useInView({
    threshold: 0.1,
  });

  const handleFoldedButtonClick = React.useCallback(() => {
    setFolded(!isFolded);
  }, [isFolded]);

  React.useEffect(() => {
    if (
      descriptionRef.current &&
      descriptionRef.current.offsetHeight <= FOLDING_THRESHOLD
    ) {
      setFoldable(false);
    }
  }, [isVisible]);

  return (
    <Typography variant="body1" color="textSecondary" ref={ref}>
      <div
        className={classNames(
          classes.description,
          isFoldable && isFolded && classes.descriptionFolded
        )}
      >
        <div
          className="description"
          ref={descriptionRef}
          style={{
            height: 130,
            textOverflow: "ellipsis",
            overflow: "hidden",
          }}
          dangerouslySetInnerHTML={{
            __html: props.description.replace(/\n/g, "<br />"),
          }}
        />{" "}
      </div>
      {isFoldable && (
        <div className={classes.buttonContainer}>
          <Button
            className={classes.button}
            // variant="contained"
            color="primary"
            onClick={handleFoldedButtonClick}
            startIcon={
              isFolded ? <KeyboardArrowDownIcon /> : <KeyboardArrowUpIcon />
            }
          >
            {isFolded ? "Read More" : "Collapse"}
          </Button>
        </div>
      )}
    </Typography>
  );
}
