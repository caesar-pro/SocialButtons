package com.caesarpro.confluence.util;

import com.atlassian.bandana.BandanaContext;

/**
 * @author Caesar pro
 */
public interface BandanaService {
    String getString(BandanaContext bandanaContext, String key, String defaultValue);
    Boolean getBoolean(BandanaContext bandanaContext, String key, Boolean defaultValue);
    void setValue(BandanaContext bandanaContext, String key, Object value);
}
