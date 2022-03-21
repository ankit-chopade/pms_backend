package com.pms.management.utils;

import org.keycloak.representations.AccessTokenResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenService {
	RestTemplate restTemplate = new RestTemplate();

	public String generateTokens(String username, String password) {

		String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("client_id", "login-ms");
		requestParams.add("username", username);
		requestParams.add("password", password);
		requestParams.add("grant_type", "password");
		requestParams.add("client_secret", "b2dabfcf-e66a-47bc-b3c3-892071c29f1e");
		requestParams.add("scope", "openid");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);

		AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);

		return keycloakAccessToken.getToken();

	}

	private AccessTokenResponse getAccessTokenResponse(HttpEntity<MultiValueMap<String, String>> request, String url) {
		try {
			ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request,
					AccessTokenResponse.class);
			return response.getBody();
		} catch (ResourceAccessException e) {
			try {
				ResponseEntity<AccessTokenResponse> response = restTemplate.postForEntity(url, request,
						AccessTokenResponse.class);
				return response.getBody();
			} catch (Exception ex) {
				throw ex;
			}
		} catch (Exception e) {
			throw e;
		}
	}

}
