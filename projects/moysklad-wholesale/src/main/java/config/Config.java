package config;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Config {
    private Map<String, Object> config;

    public Config() throws FileNotFoundException {
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

    private Map<String, Object> getBitrixGroup() {
        return (Map<String, Object>) config.get("bitrix");
    }

    private Map<String, Object> getMoySkladGroup() {
        return (Map<String, Object>) config.get("moysklad");
    }

    private Map<String, Object> getRetailCRMGroup() {
        return (Map<String, Object>) config.get("retailcrm");
    }

    private Map<String, Object> getBrandingGroup() {
        return (Map<String, Object>) config.get("branding");
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

    public String getMoySkladPriceType() {
        Map<String, Object> moyskladGroup = getMoySkladGroup();

        return (String) moyskladGroup.get("priceType");
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

    public String getRetailCRMSiteId() {
        Map<String, Object> retailCRMGroup = getRetailCRMGroup();

        return (String) retailCRMGroup.get("siteId");
    }

    public Integer getRetailCRMWholesaleOrderStartNum() {
        Map<String, Object> retailCRMGroup = getRetailCRMGroup();

        return (int) Math.round((Double) retailCRMGroup.get("wholesaleOrderStartNum"));
    }

    public String getBitrixAvailableProductsEndPoint() {
        Map<String, Object> bitrixGroup = getBitrixGroup();

        return (String) bitrixGroup.get("availableProductsEndPoint");
    }

    public String getBitrixBaseUrl() {
        Map<String, Object> bitrixGroup = getBitrixGroup();

        return (String) bitrixGroup.get("baseUrl");
    }

    public String getBrandingCatalogName() {
        Map<String, Object> brandingGroup = getBrandingGroup();

        return (String) brandingGroup.get("catalogName");
    }

    public String getBrandingCatalogText() {
        Map<String, Object> brandingGroup = getBrandingGroup();

        return (String) brandingGroup.get("catalogText");
    }
}
