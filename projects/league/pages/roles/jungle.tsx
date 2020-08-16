import * as React from "react";
import { Layout } from "../../components/layout/Layout";

export default function Page(): JSX.Element {
  return (
    <Layout title={`Jungle`}>
      <h1>Jungle</h1>
      <h2>Junglers with solo-clear</h2>
      <ul>
        <li>Graves</li>
        <li>Ivern</li>
        <li>Kayn</li>
        <li>Lee Sin</li>
        <li>Olaf</li>
        <li>Shaco</li>
        <li>Trundle</li>
        <li>Udyr</li>
        <li>Warwick</li>
        <li>Xin Zhao</li>
        <li>Zac</li>
      </ul>
    </Layout>
  );
}
