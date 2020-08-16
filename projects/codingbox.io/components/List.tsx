import * as React from "react";
import ListItem from "./ListItem";
import { User } from "../@types";

type Props = {
  items: User[];
};

const List: React.FunctionComponent<Props> = ({ items }: Props) => (
  <ul>
    {items.map((item) => (
      <li key={item.id}>
        <ListItem data={item} />
      </li>
    ))}
  </ul>
);

export default List;
