package com.caesarpro.confluence.util;

import com.atlassian.bandana.BandanaContext;

/**
 * Created with IntelliJ IDEA.
 * User: anpi0413
 * Date: 13.02.15
 * Time: 18:35
 * Project: ScrollToTop
 * To change this template use File | Settings | File Templates.
 */
public interface BandanaService {
    String getString(BandanaContext bandanaContext, String key, String defaultValue);
    Boolean getBoolean(BandanaContext bandanaContext, String key, Boolean defaultValue);
    void setValue(BandanaContext bandanaContext, String key, Object value);
}
