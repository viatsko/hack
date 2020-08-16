/// <reference types="typography" />

declare module "typography-theme-wordpress-2016" {
    import { TypographyOptions, VerticalRhythm, GoogleFont } from "typography";

    export default class {
        public static overrideThemeStyles?: (VerticalRhythm: VerticalRhythm, options: TypographyOptions, styles: any) => object;
        public static googleFonts?: GoogleFont[];
    }
}
