package model;

import javafx.scene.paint.Color;

public class Theme {
    private final Color primaryColor;
    private final Color secondaryColor;

    public static final Theme DEFAULT_THEME = new Theme(
            Color.MINTCREAM,
            Color.BLACK
    );

    public static final Theme ALT_THEME_1 = new Theme(
            Color.GOLD,
            Color.GOLDENROD
    );

    public Theme(Color primaryColor, Color secondaryColor)
    {
        this.primaryColor = primaryColor;
        this.secondaryColor = secondaryColor;
    }

    private Color getPrimaryColor() {
        return primaryColor;
    }

    private Color getSecondaryColor() {
        return secondaryColor;
    }

    public Color getSquarePrimaryColor()
    {
        return getPrimaryColor();
    }

    public Color getSquareSecondaryColor()
    {
        return getSecondaryColor();
    }

    public Color getSquareStrokeColor()
    {
        if (getPrimaryColor().getBrightness() >= getSecondaryColor().getBrightness())
            return getSecondaryColor();
        else
            return getPrimaryColor();
    }

    public Color getFramePrimaryColor()
    {
        if (getPrimaryColor().getBrightness() >= getSecondaryColor().getBrightness())
            return getPrimaryColor();
        else
            return getSecondaryColor();
    }

    public Color getFrameSecondaryColor()
    {
        if (getPrimaryColor().getBrightness() >= getSecondaryColor().getBrightness())
            return getSecondaryColor();
        else
            return getPrimaryColor();
    }

    public Color getFrameStrokeColor()
    {
        return getFramePrimaryColor();
    }

    public Color getWhitePiecesColor()
    {
        return getPrimaryColor();
    }

    public Color getWhitePiecesStrokeColor()
    {
        return getSecondaryColor();
    }

    public Color getBlackPiecesColor()
    {
        return getSecondaryColor();
    }

    public Color getBlackPiecesStrokeColor()
    {
        return getPrimaryColor();
    }

}
