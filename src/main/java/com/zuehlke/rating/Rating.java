package com.zuehlke.rating;

import com.zuehlke.rating.omdb.OmdbRating;

@SuppressWarnings("unused")
public class Rating {
    private final String source;
    private final String value;

    public Rating(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public static Rating from(OmdbRating r) {
        return new Rating(r.getSource(), r.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rating rating = (Rating) o;

        if (!source.equals(rating.source)) return false;
        return value.equals(rating.value);
    }

    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
