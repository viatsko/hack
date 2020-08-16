import React, { ReactNode } from "react";
import { graphql } from "gatsby";

import Layout from "../components/layout";
import SEO from "../components/seo";

interface Props {
    data: {
        site: {
            siteMetadata: {
                title: string;
            };
        };
    };

    location: Location;
}

class NotFoundPage extends React.Component<Props> {
    public render(): ReactNode {
        const { data } = this.props;
        const siteTitle = data.site.siteMetadata.title;

        return (
            <Layout location={this.props.location} title={siteTitle}>
                <SEO title="404: Not Found" />
                <h1>Not Found</h1>
                <p>You just hit a route that doesn&#39;t exist... the sadness.</p>
            </Layout>
        );
    }
}

export default NotFoundPage;

export const pageQuery = graphql`
    query {
        site {
            siteMetadata {
                title
            }
        }
    }
`;
