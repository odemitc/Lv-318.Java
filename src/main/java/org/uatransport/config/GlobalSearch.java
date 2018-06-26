package org.uatransport.config;
import lombok.Data;

public class GlobalSearch {
    private String globalSearch="";

    public GlobalSearch(String globalSearch) {
        this.globalSearch = globalSearch;
    }

    public String getGlobalSearch() {
        return globalSearch;
    }

    public void setGlobalSearch(String globalSearch) {
        this.globalSearch = globalSearch;
    }
}
