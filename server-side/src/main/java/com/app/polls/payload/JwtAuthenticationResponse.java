package com.app.polls.payload;

public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = "Bearer";
    private boolean result = true;
    private String UsernameOrEmail;

    public String getUsernameOrEmail() {
		return UsernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.UsernameOrEmail = usernameOrEmail;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public JwtAuthenticationResponse(String accessToken,String UsernameOrEmail) {
        this.accessToken = accessToken;
        this.UsernameOrEmail = UsernameOrEmail;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
