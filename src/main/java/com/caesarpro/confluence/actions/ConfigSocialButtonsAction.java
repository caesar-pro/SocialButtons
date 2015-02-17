package com.caesarpro.confluence.actions;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.confluence.core.ConfluenceActionSupport;
import com.caesarpro.confluence.util.BandanaData;
import com.caesarpro.confluence.util.BandanaService;

/**
 * @author Caesar pro
 */
public class ConfigSocialButtonsAction extends ConfluenceActionSupport {
    private final static BandanaContext CONTEXT = BandanaData.bandanaContext;
    private final BandanaService bandanaService;

    public ConfigSocialButtonsAction(BandanaService bandanaService) {
        this.bandanaService = bandanaService;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getSkin() {
        return bandanaService.getString(CONTEXT, BandanaData.THEME_KEY, "classic");
    }

    public boolean getShowCounters() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.COUNTERS_KEY, true);
    }

    public boolean getShowFacebookBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.FACEBOOK_KEY, true);
    }

    public boolean getShowTwitterBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.TWITTER_KEY, true);
    }

    public boolean getShowMailruBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.MAILRU_KEY, false);
    }

    public boolean getShowVkontakteBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.VKONTAKTE_KEY, false);
    }

    public boolean getShowOdnoklassnikiBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.ODNOKLASSNIKI_KEY, false);
    }

    public boolean getShowPlusoneBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.PLUSONE_KEY, true);
    }

    public boolean getShowPinterestBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.PINTEREST_KEY, false);
    }

    public boolean getReplaceLikeBtn() {
        return bandanaService.getBoolean(CONTEXT, BandanaData.REPLACE_LIKE_BTN, false);
    }
}
