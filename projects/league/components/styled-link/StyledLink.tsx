import * as React from "react";
import Link from "next/link";
import MaterialUILink from "@material-ui/core/Link";
import classNames from "classnames";
import { makeStyles } from "@material-ui/core";

interface Props {
  href?: string;
  as?: string;
  key?: string;
  className?: string;
  onClick?: () => void;
  children: React.ReactNode;
}

const useStyles = makeStyles(() => ({
  link: {
    cursor: "pointer",
  },
}));

export function StyledLink(props: Props): JSX.Element {
  const styles = useStyles();

  const extraNextProps: any = {};

  let href: string | undefined;
  if (props.href) {
    href = props.href.replace(/\/$/, "");
  }

  if (props.href?.indexOf("/product-category/") !== -1) {
    extraNextProps["as"] = href;
    extraNextProps["href"] =
      props.href?.split("/").length === 4
        ? "/product-category/[parentCategory]/[childCategory]"
        : "/product-category/[parentCategory]";
  } else if (props.href?.indexOf("/product/") !== -1) {
    extraNextProps["as"] = href;
    extraNextProps["href"] = "/product/[slug]";
  } else if (props.href?.indexOf("/champions/") !== -1) {
    extraNextProps["as"] = href;
    extraNextProps["href"] = "/champions/[id]";
  }

  return props.href ? (
    props.href.indexOf("http") === 0 ? (
      <a href={props.href} className={classNames(styles.link, props.className)}>
        {props.children}
      </a>
    ) : (
      <Link href={href} as={props.as} passHref={true} {...extraNextProps}>
        <MaterialUILink
          className={classNames(styles.link, props.className)}
          onClick={() => {
            Array.from(
              document.querySelectorAll("[data-hoverable-element]")
            ).forEach((el) => {
              (el as HTMLElement).style.pointerEvents = "none";
            });

            setTimeout(function () {
              Array.from(
                document.querySelectorAll("[data-hoverable-element]")
              ).forEach((el) => {
                (el as HTMLElement).style.pointerEvents = "auto";
              });
            }, 250);
          }}
        >
          {props.children}
        </MaterialUILink>
      </Link>
    )
  ) : (
    <MaterialUILink
      className={classNames(styles.link, props.className)}
      onClick={props.onClick}
    >
      {props.children}
    </MaterialUILink>
  );
}
