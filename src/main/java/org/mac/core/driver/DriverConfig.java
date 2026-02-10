package org.mac.core.driver;


public final class DriverConfig {

    private final String browser;
    private final boolean headless;
    private final String gridUrl;
    private final int implicitWait;

    private DriverConfig(Builder builder) {
        this.browser = builder.browser;
        this.headless = builder.headless;
        this.gridUrl = builder.gridUrl;
        this.implicitWait = builder.implicitWait;
    }

    public String getBrowser() { return browser; }
    public boolean isHeadless() { return headless; }
    public String getGridUrl() { return gridUrl; }
    public int getImplicitWait() { return implicitWait; }

    // 🔥 BUILDER
    public static class Builder {
        private String browser = "chrome";
        private boolean headless = false;
        private String gridUrl = null;
        private int implicitWait = 10;

        public Builder browser(String browser) {
            this.browser = browser;
            return this;
        }

        public Builder headless(boolean headless) {
            this.headless = headless;
            return this;
        }

        public Builder gridUrl(String gridUrl) {
            this.gridUrl = gridUrl;
            return this;
        }

        public Builder implicitWait(int seconds) {
            this.implicitWait = seconds;
            return this;
        }

        public DriverConfig build() {
            return new DriverConfig(this);
        }
    }
}