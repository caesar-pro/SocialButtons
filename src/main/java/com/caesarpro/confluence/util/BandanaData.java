package com.caesarpro.confluence.util;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.confluence.setup.bandana.ConfluenceBandanaContext;

/**
 * @author Caesar pro
 */
public class BandanaData {
    public static final BandanaContext bandanaContext = new ConfluenceBandanaContext("SocialButtons");
    public static final String THEME_KEY = "theme";
    public static final String COUNTERS_KEY = "counters";
    public static final String FACEBOOK_KEY = "facebook";
    public static final String TWITTER_KEY = "twitter";
    public static final String MAILRU_KEY = "mailru";
    public static final String VKONTAKTE_KEY = "vkontakte";
    public static final String ODNOKLASSNIKI_KEY = "odnoklassniki";
    public static final String PLUSONE_KEY = "plusone";
    public static final String PINTEREST_KEY = "pinterest";
    public static final String REPLACE_LIKE_BTN = "ReplaceLikeBtn";
}
