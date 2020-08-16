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

package me.viatsko.retailcrm_moysklad_sync;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, Object> config;

    Config() throws FileNotFoundException {
        config = readConfig();
    }

    private Map<String, Object> readConfig() throws FileNotFoundException {
        Map<String, Object> result = new HashMap<>();

        ClassLoader classLoader = getClass().getClassLoader();

        Gson gson = new Gson();

        JsonReader reader = new JsonReader(new InputStreamReader(classLoader.getResourceAsStream("config.json")));

        result = gson.fromJson(reader, result.getClass());

        return result;
    }

    private Map<String, Object> getMoySkladGroup() {
        return (Map<String, Object>) config.get("moysklad");
    }

    private Map<String, Object> getRetailCRMGroup() {
        return (Map<String, Object>) config.get("retailcrm");
    }

    public String getMoySkladUsername() {
        Map<String, Object> moyskladGroup = getMoySkladGroup();

        return (String) moyskladGroup.get("username");
    }

    public String getMoySkladPassword() {
        Map<String, Object> moyskladGroup = getMoySkladGroup();

        return (String) moyskladGroup.get("password");
    }

    public String getMoySkladOrganizationHref() {
		Map<String, Object> moyskladGroup = getMoySkladGroup();

		return (String) moyskladGroup.get("organizationHref");
	}

	public String getMoySkladStoreHref() {
		Map<String, Object> moyskladGroup = getMoySkladGroup();

		return (String) moyskladGroup.get("storeHref");
	}

    public String getRetailCRMURI() {
        Map<String, Object> retailCRMGroup = getRetailCRMGroup();

        return (String) retailCRMGroup.get("url");
    }

    public String getRetailCRMKey() {
        Map<String, Object> retailCRMGroup = getRetailCRMGroup();

        return (String) retailCRMGroup.get("key");
    }
}
