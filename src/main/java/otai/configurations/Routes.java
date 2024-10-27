package otai.configurations;

import java.util.ResourceBundle;

public class Routes {
    public static ResourceBundle getURL() {
        return ResourceBundle.getBundle("config");
    }

    public static ResourceBundle getTimeout() {
        return ResourceBundle.getBundle("config");
    }

    public static final String LOGIN_URL = getURL().getString("otai-auto-e2e.login-url");
    public static final String HOME_URL = getURL().getString("otai-auto-e2e.home-url");
    public static final String LEAVES_URL = getURL().getString("otai-ui-e2e.leaves-url");
    public static final long LOGIN_TIMEOUT = Long.parseLong(getTimeout().getString("otai-auto-e2e.timeout"));
}
