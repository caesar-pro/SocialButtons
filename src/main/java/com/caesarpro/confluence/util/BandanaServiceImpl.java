package com.caesarpro.confluence.util;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.bandana.BandanaManager;

/**
 * @author Caesar pro
 */
public class BandanaServiceImpl implements BandanaService {
    private final BandanaManager bandanaManager;

    /*

     */
    public BandanaServiceImpl(BandanaManager bandanaManager) {
        this.bandanaManager = bandanaManager;
    }

    @Override
    public String getString(BandanaContext bandanaContext, String key, String defaultValue) {
        Object value = bandanaManager.getValue(bandanaContext, key);

        if (value == null) {
            bandanaManager.setValue(bandanaContext, key, defaultValue);

            return defaultValue;
        }

        return String.valueOf(value);
    }

    @Override
    public Boolean getBoolean(BandanaContext bandanaContext, String key, Boolean defaultValue) {
        Object value = bandanaManager.getValue(bandanaContext, key);

        if (value == null) {
            bandanaManager.setValue(bandanaContext, key, defaultValue);

            return defaultValue;
        }

        return Boolean.valueOf(String.valueOf(value));
    }

    @Override
    public void setValue(BandanaContext bandanaContext, String key, Object value) {
        bandanaManager.setValue(bandanaContext, key, value);
    }
}
