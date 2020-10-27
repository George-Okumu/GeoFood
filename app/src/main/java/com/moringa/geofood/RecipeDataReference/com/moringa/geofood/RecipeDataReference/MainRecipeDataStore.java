
package com.moringa.geofood.RecipeDataReference;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainRecipeDataStore {

    @SerializedName("q")
    @Expose
    private String q;
    @SerializedName("from")
    @Expose
    private Long from;
    @SerializedName("to")
    @Expose
    private Long to;
    @SerializedName("more")
    @Expose
    private Boolean more;
    @SerializedName("count")
    @Expose
    private Long count;
    @SerializedName("hits")
    @Expose
    private List<Hit> hits = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MainRecipeDataStore() {
    }

    /**
     * 
     * @param hits
     * @param q
     * @param more
     * @param count
     * @param from
     * @param to
     */
    public MainRecipeDataStore(String q, Long from, Long to, Boolean more, Long count, List<Hit> hits) {
        super();
        this.q = q;
        this.from = from;
        this.to = to;
        this.more = more;
        this.count = count;
        this.hits = hits;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }

    public Boolean getMore() {
        return more;
    }

    public void setMore(Boolean more) {
        this.more = more;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<Hit> getHits() {
        return hits;
    }

    public void setHits(List<Hit> hits) {
        this.hits = hits;
    }

}
