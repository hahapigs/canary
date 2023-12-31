package com.example.canary.common.i18n;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.Locale;

/**
 * 自定义区域解析器
 *
 * @since 1.0
 * @author zhaohongliang
 */
public class MyLocalResolver implements LocaleResolver {

    @Override
    public @NotNull Locale resolveLocale(HttpServletRequest request) {
        // header: String lang = request.getHeader(I18nConstant.LANG)
        String lang = request.getParameter(I18nConstant.LANG);
        Locale locale = Locale.getDefault();
        if (StringUtils.hasText(lang)) {
            String[] array = lang.split("_");
            locale = new Locale(array[0], array[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(@NotNull HttpServletRequest request, HttpServletResponse response, Locale locale) {
        // TODO document why this method is empty
    }
}
