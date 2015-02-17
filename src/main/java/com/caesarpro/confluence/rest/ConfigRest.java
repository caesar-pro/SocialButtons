package com.caesarpro.confluence.rest;

import com.atlassian.bandana.BandanaContext;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import com.caesarpro.confluence.util.BandanaData;
import com.caesarpro.confluence.util.BandanaService;
import com.google.gson.Gson;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.TEXT_PLAIN;

/**
 * @author Caesar pro
 */
@Path("/config")
public class ConfigRest {
    public static final List SKINS = Arrays.asList("classic", "flat", "birman");
    public static final List BUTTONS = Arrays.asList(
            BandanaData.FACEBOOK_KEY,
            BandanaData.TWITTER_KEY,
            BandanaData.MAILRU_KEY,
            BandanaData.VKONTAKTE_KEY,
            BandanaData.ODNOKLASSNIKI_KEY,
            BandanaData.PLUSONE_KEY,
            BandanaData.PINTEREST_KEY);
    private final static BandanaContext CONTEXT = BandanaData.bandanaContext;
    private final BandanaService bandanaService;

    public ConfigRest(BandanaService bandanaService) {
        this.bandanaService = bandanaService;
    }

    @GET /*    /rest/socialbuttons/1.0/config/getButtons    */
    @Path("getButtons")
    @Produces({APPLICATION_JSON})
    public Response getButtons() {
        Map context = MacroUtils.defaultVelocityContext();

        boolean showFaceBookBtn = bandanaService.getBoolean(CONTEXT, BandanaData.FACEBOOK_KEY, true);
        boolean showTwitterBtn = bandanaService.getBoolean(CONTEXT, BandanaData.TWITTER_KEY, true);
        boolean showPlusoneBtn = bandanaService.getBoolean(CONTEXT, BandanaData.PLUSONE_KEY, true);
        boolean showMailruBtn = bandanaService.getBoolean(CONTEXT, BandanaData.MAILRU_KEY, false);
        boolean showVkontakteBtn = bandanaService.getBoolean(CONTEXT, BandanaData.VKONTAKTE_KEY, false);
        boolean showOdnoklassnikiBtn = bandanaService.getBoolean(CONTEXT, BandanaData.ODNOKLASSNIKI_KEY, false);
        boolean showPinterestBtn = bandanaService.getBoolean(CONTEXT, BandanaData.PINTEREST_KEY, false);
        String theme = bandanaService.getString(CONTEXT, BandanaData.THEME_KEY, "classic");
        boolean showCounters = bandanaService.getBoolean(CONTEXT, BandanaData.COUNTERS_KEY, true);

        context.put("showFaceBookBtn", showFaceBookBtn);
        context.put("showTwitterBtn", showTwitterBtn);
        context.put("showMailruBtn", showMailruBtn);
        context.put("showVkontakteBtn", showVkontakteBtn);
        context.put("showOdnoklassnikiBtn", showOdnoklassnikiBtn);
        context.put("showPlusoneBtn", showPlusoneBtn);
        context.put("showPinterestBtn", showPinterestBtn);
        context.put("theme", theme);
        context.put("showCounters", showCounters);

        String buttonsHtml = VelocityUtils.getRenderedTemplate("templates/social-buttons.vm", context);

        Map resultMap = new HashMap();
        resultMap.put("html", buttonsHtml);

        boolean replaceLikeBtn = bandanaService.getBoolean(CONTEXT, BandanaData.REPLACE_LIKE_BTN, false);
        resultMap.put("replaceLikeBtn", replaceLikeBtn);

        return Response.ok(new Gson().toJson(resultMap), MediaType.APPLICATION_JSON).build();
    }

    @GET /*    /rest/socialbuttons/1.0/config/setSkin/classic    */
    @Path("setSkin/{skinName}")
    @Produces({TEXT_PLAIN})
    public Response setSkin(@PathParam("skinName") String skinName) {
        if (SKINS.contains(skinName)) {
            bandanaService.setValue(CONTEXT, BandanaData.THEME_KEY, skinName);

            return Response.ok().build();
        }

        return Response.serverError().build();
    }

    @GET /*    /rest/socialbuttons/1.0/config/changeButton/twitter/true    */
    @Path("changeButton/{buttonName}/{state}")
    @Produces({TEXT_PLAIN})
    public Response changeButton(@PathParam("buttonName") String buttonName, @PathParam("state") Boolean state) {
        if (BUTTONS.contains(buttonName)) {
            bandanaService.setValue(CONTEXT, buttonName, state);

            return Response.ok().build();
        }

        return Response.serverError().build();
    }

    @GET /*    /rest/socialbuttons/1.0/config/setShowCounters/true    */
    @Path("setShowCounters/{state}")
    @Produces({TEXT_PLAIN})
    public Response setShowCounters(@PathParam("state") Boolean state) {
        bandanaService.setValue(CONTEXT, BandanaData.COUNTERS_KEY, state);

        return Response.ok().build();
    }

    @GET /*    /rest/socialbuttons/1.0/config/setReplaceLikeBtn/true    */
    @Path("setReplaceLikeBtn/{state}")
    @Produces({TEXT_PLAIN})
    public Response setReplaceLikeBtn(@PathParam("state") Boolean state) {
        bandanaService.setValue(CONTEXT, BandanaData.REPLACE_LIKE_BTN, state);

        return Response.ok().build();
    }
}
