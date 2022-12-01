package Colours;

import java.util.HashMap;

public class ThemeControl {
    // Stores and retrieves all possible theme packs
    HashMap<String, Theme> themeOptions;
    String currTheme;

    public ThemeControl(){
        themeOptions = new HashMap<>();
        themeOptions.put("Light", new LightTheme());

        currTheme = "Light";
    }

    public String getBackColour(){
        return themeOptions.get(currTheme).getBackColour();
    }

}
