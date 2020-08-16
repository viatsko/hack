// You can include shared interfaces/types in a separate file
// and then use them in any component by importing them. For
// example, to import the interface below do:
//
// import User from 'path/to/interfaces';

export type User = {
  id: number;
  name: string;
};

type Thumbnail = {
  url: string;
  width: number;
  height: number;
};

export type ProfileSchema = {
  displayName: string;

  description: string;

  thumbnails: {
    default: Thumbnail;
    medium?: Thumbnail;
    high?: Thumbnail;
  };

  youtubeChannel: {
    uploadsPlaylist: string;

    metadata: {
      id: string;
    };
  };

  tags?: string[];
};

export type ProfileIndexSchemaProfile = {
  slug: string;
  displayName: string;
  avatar: string;
  tags: string[];
};

export type ProfileIndexSchema = {
  profiles: ProfileIndexSchemaProfile[];
};

export type YouTubeVideo = {
  publishedAt: string;
  title: string;
  description: string;
  videoId: string;
};

export type FeedItemProfile = {
  avatar: string;
  slug: string;
  displayName: string;
};

export type FeedItemYoutube = {
  video: YouTubeVideo;
  profile: FeedItemProfile;
};

export type Hub = {
  displayName: string;
  slug: string;
  profiles: ProfileIndexSchema["profiles"];
};

export type FeedItem = FeedItemYoutube;
