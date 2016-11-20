package com.example.nowfeed.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rusili on 11/9/16.
 */

public class TopStory {

    String status;
    String copyright;
    String section;
    String last_updated;
    int num_results;
    List<results> results = new ArrayList<>();

    public String getStatus() {
        return this.status;
    }

    public List<results> getResults() {
        return this.results;
    }

    public class results {
        String section;
        String subsection;
        String title;
        String _abstract;
        String url;
        String byline;
        String item_type;
        String updated_type;
        String created_date;
        String published_date;
        String material_type_facet;
        String kicker;
        List<String> des_facet = new ArrayList<>();
        List<String> org_facet = new ArrayList<>();
        List<String> per_facet = new ArrayList<>();
        List<String> geo_facet = new ArrayList<>();
        List<multimedia> multimedia = new ArrayList<>();
        String short_url;

        public String getTitle() {
            return this.title;
        }

        public String getByline() {
            return this.byline;
        }

        public List<multimedia> getMultimedia() {
            return multimedia;
        }

        public String getUrl() {
            return this.url;
        }

        public class des_facet {
        }

        public class org_facet {
        }

        public class per_facet {
        }

        public class geo_facet {
        }

        public class multimedia {
            String url;
            String format;
            int height;
            int width;
            String type;
            String subtype;
            String caption;
            String copyright;

            public String getUrl() {
                return this.url;
            }
        }
    }
}
