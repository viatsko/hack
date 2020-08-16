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

export type ChampionSchema = {
  id: string;
  key: string;
  name: string;
  title: string;
  tags: string[];
  stats: {
    hp: string;
    hpperlevel: number;
    mp: number;
    mpperlevel: number;
    movespeed: number;
    armor: number;
    armorperlevel: number;
    spellblock: number;
    spellblockperlevel: number;
    attackrange: number;
    hpregen: number;
    hpregenperlevel: number;
    mpregen: number;
    mpregenperlevel: number;
    crit: number;
    critperlevel: number;
    attackdamage: number;
    attackdamageperlevel: number;
    attackspeedperlevel: number;
    attackspeed: number;
  };
  icon: string;
  sprite: {
    url: string;
    x: number;
    y: number;
  };
  description: string;
  videos: YouTubeVideo[];
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

  russian?: boolean;
  replays?: boolean;
};

export type ProfileIndexSchemaProfile = {
  slug: string;
  displayName: string;
  avatar: string;
  tags: string[];
  russian: boolean;
  replays: boolean;
};

export type ProfileIndexSchema = {
  profiles: ProfileIndexSchemaProfile[];
};

export type YouTubeVideo = {
  publishedAt: string;
  title: string;
  description: string;
  videoId: string;
  preview?: string;
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

export type RedditItem = {
  title: string;
  selftext?: string;
  selftext_html?: string;
  media_embed?: {
    content?: string;
    width?: number;
    height?: number;
  };
  thumbnail?: string;
  permalink?: string;
  url?: string;
  created_utc?: number;
  preview?: {
    images?: { source?: { url?: string; width?: number; height?: number } }[];
  };
};

export type FeedItem = FeedItemYoutube;
