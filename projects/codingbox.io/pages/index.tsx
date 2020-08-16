import * as React from "react";
import { Layout } from "../components/Layout";
import { Feed } from "../components/Feed";

const IndexPage = (): JSX.Element => (
  <Layout title="Latest updates">
    <Feed feedItems={require("../feed-main-above-the-fold.generated.json")} />
  </Layout>
);

export default IndexPage;
