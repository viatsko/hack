import * as React from "react";
import { Layout } from "../components/layout/Layout";
import { Feed } from "../components/feed/Feed";

const IndexPage = (): JSX.Element => (
  <Layout title="Latest updates">
    <Feed
      feedItems={require("../feed-main-above-the-fold.generated.json")}
      count={4}
    />
  </Layout>
);

export default IndexPage;
