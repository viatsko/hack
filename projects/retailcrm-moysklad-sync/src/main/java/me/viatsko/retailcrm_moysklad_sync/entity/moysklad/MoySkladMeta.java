/*-
 * -\-\-
 * retailcrm-moysklad-sync
 * --
 * Copyright (C) 2017 Valerii Iatsko
 * --
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * -/-/-
 */

package me.viatsko.retailcrm_moysklad_sync.entity.moysklad;

public class MoySkladMeta {
    public String href;

    public String metadataHref;

    public String type;

    public String mediaType;

    public String uuidHref;

    public String getHref() {
        return href;
    }

    public String getMetadataHref() {
        return metadataHref;
    }

    public String getType() {
        return type;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getUuidHref() {
        return uuidHref;
    }

    @Override
    public String toString() {
        return "MoySkladMeta{" +
                "href='" + href + '\'' +
                ", metadataHref='" + metadataHref + '\'' +
                ", type='" + type + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", uuidHref='" + uuidHref + '\'' +
                '}';
    }

    public static final class MoySkladMetaBuilder {
        public String href;
        public String metadataHref;
        public String type;
        public String mediaType;
        public String uuidHref;

        public MoySkladMetaBuilder() {
        }

        public static MoySkladMetaBuilder aMoySkladMeta() {
            return new MoySkladMetaBuilder();
        }

        public MoySkladMetaBuilder withHref(String href) {
            this.href = href;
            return this;
        }

        public MoySkladMetaBuilder withMetadataHref(String metadataHref) {
            this.metadataHref = metadataHref;
            return this;
        }

        public MoySkladMetaBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public MoySkladMetaBuilder withMediaType(String mediaType) {
            this.mediaType = mediaType;
            return this;
        }

        public MoySkladMetaBuilder withUuidHref(String uuidHref) {
            this.uuidHref = uuidHref;
            return this;
        }

        public MoySkladMeta build() {
            MoySkladMeta moySkladMeta = new MoySkladMeta();
            moySkladMeta.mediaType = this.mediaType;
            moySkladMeta.type = this.type;
            moySkladMeta.uuidHref = this.uuidHref;
            moySkladMeta.href = this.href;
            moySkladMeta.metadataHref = this.metadataHref;
            return moySkladMeta;
        }
    }
}
