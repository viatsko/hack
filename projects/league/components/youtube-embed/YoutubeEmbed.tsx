import * as React from "react";
import YouTube from "react-youtube";

interface Props {
  videoId: string;
}

const _onReady = (event: any) => {
  // access to player in all event handlers via event.target
  event.target.pauseVideo();
};

export function YoutubeEmbed(props: Props): JSX.Element {
  const opts = {
    height: "200px",
    width: "100%",
    playerVars: {
      // https://developers.google.com/youtube/player_parameters
      autoplay: 0,
    },
  };

  return (
    <div
      className="video"
      style={{
        position: "relative",
        paddingBottom: 240,
        paddingTop: 25,
        height: 0,
      }}
    >
      <YouTube videoId={props.videoId} opts={opts as any} onReady={_onReady} />
      {/* <iframe
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
      /> */}
    </div>
  );
}
