import * as React from "react";

interface Props {
  videoId: string;
}

export function YoutubeEmbed(props: Props): JSX.Element {
  return (
    <div
      className="video"
      style={{
        position: "relative",
        paddingBottom: "56.25%" /* 16:9 */,
        paddingTop: 25,
        height: 0,
      }}
    >
      <iframe
        style={{
          position: "absolute",
          top: 0,
          left: 0,
          width: "100%",
          height: "100%",
        }}
        {...({
          loading: "lazy",
          // eslint-disable-next-line @typescript-eslint/no-explicit-any
        } as any)}
        width="2000"
        src={`https://www.youtube.com/embed/${props.videoId}`}
        frameBorder="0"
        allowFullScreen={true}
      />
    </div>
  );
}
