package frameworks.constants;

public enum BrowsersTypes {

    CHROME("chrome"),
    FIREFOX("firefox"),
    EDGE("edge"),
    SAFARI("safari"),
    OPERA("opera");


    private String browser;

    BrowsersTypes(String browser)
    {
        this.browser=browser;
    }
    public String getBrowser()
    {
        return browser;
    }


}
