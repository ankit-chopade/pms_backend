package com.pms.management.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.keycloak.representations.AccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.pms.management.dto.UserDto;

@Service
public class KeyCloakService {
	
	@Autowired
	RestTemplate restTemplate ;
	
	@Value("${mykeycloak.clientid}")
	private String clientId;
	
	@Value("${mykeycloak.clientsecret}")
	private String clientSecret;
	
	@Value("${mykeycloak.admin.username}")
	private String adminUsername;
	
	@Value("${mykeycloak.admin.password}")
	private String adminPassword;
	
	@Value("${mykeycloak.patient.id}")
	private String patientId;
	
	@Value("${mykeycloak.physician.id}")
	private String physicianId;
	
	@Value("${mykeycloak.nurse.id}")
	private String nurseId;
	
	@Value("${mykeycloak.admin.id}")
	private String adminId;
	
	public void saveUserInKeyclock(String username, String password) {

		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id",clientId);
			requestParams.add("username", adminUsername);
			requestParams.add("password", adminPassword);
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", clientSecret);
			requestParams.add("scope", "openid");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
			AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);
			String tokenAdmin = keycloakAccessToken.getToken().trim();

			String urlRegister = "http://localhost:8180/auth/admin/realms/pms/users";
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "password");
			jsonObj.put("value", password);

			JSONArray credentials = new JSONArray();
			credentials.put(jsonObj);
			JSONObject userParam = new JSONObject();
			userParam.put("username", username);
			userParam.put("credentials", credentials);
			userParam.put("enabled", "true");
			userParam.put("emailVerified", "true");

			HttpHeaders headersUser = new HttpHeaders();
			headersUser.setContentType(MediaType.APPLICATION_JSON);
			headersUser.add("Authorization", "Bearer " + tokenAdmin);
			HttpEntity<String> requestUser = new HttpEntity<String>(userParam.toString(), headersUser);
			restTemplate.postForEntity(urlRegister, requestUser, String.class);

			/**
			 * User id
			 */
			String urlUserid = "http://localhost:8180/auth/admin/realms/pms/users/?username=" + username;
			HttpHeaders headersUserid = new HttpHeaders();
			headersUserid.setContentType(MediaType.APPLICATION_JSON);
			headersUserid.add("Authorization", "Bearer " + tokenAdmin);
			HttpEntity<String> requestUserid = new HttpEntity<>(headersUserid);
			ResponseEntity respUserid = restTemplate.exchange(urlUserid, HttpMethod.GET, requestUserid,
					String.class);
			JSONArray useridJson = new JSONArray(respUserid.getBody().toString());

			/**
			 * Role Mapping
			 */
			String urlRole = "http://localhost:8180/auth/admin/realms/pms/users/"
					+ useridJson.getJSONObject(0).get("id") + "/role-mappings/realm";
			HttpHeaders headersRole = new HttpHeaders();
			headersRole.setContentType(MediaType.APPLICATION_JSON);
			headersRole.add("Authorization", "Bearer " + tokenAdmin);

			JSONObject roleParam = new JSONObject();
			roleParam.put("id", patientId);
			roleParam.put("name", "patient");

			JSONArray roleArray = new JSONArray();
			roleArray.put(roleParam);

			HttpEntity<String> requestRole = new HttpEntity<>(roleArray.toString(), headersRole);
			restTemplate.exchange(urlRole, HttpMethod.POST, requestRole, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void addUserInKeyclock(UserDto dto, String password) {
		String username = dto.getEmailId();

		try {

			String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

			/**
			 * Admin password
			 */
			MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
			requestParams.add("client_id", clientId);
			requestParams.add("username", adminUsername);
			requestParams.add("password", adminPassword);
			requestParams.add("grant_type", "password");
			requestParams.add("client_secret", clientSecret);
			requestParams.add("scope", "openid");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
			AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);
			String tokenAdmin = keycloakAccessToken.getToken().trim();

			String urlRegister = "http://localhost:8180/auth/admin/realms/pms/users";
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "password");
			jsonObj.put("value", password);

			JSONArray credentials = new JSONArray();
			credentials.put(jsonObj);
			JSONObject userParam = new JSONObject();
			userParam.put("username", username);
			userParam.put("credentials", credentials);
			userParam.put("enabled", "true");
			userParam.put("emailVerified", "true");

			HttpHeaders headersUser = new HttpHeaders();
			headersUser.setContentType(MediaType.APPLICATION_JSON);
			headersUser.add("Authorization", "Bearer " + tokenAdmin);
			HttpEntity<String> requestUser = new HttpEntity<>(userParam.toString(), headersUser);
			restTemplate.postForEntity(urlRegister, requestUser, String.class);

			/**
			 * User id
			 */
			String urlUserid = "http://localhost:8180/auth/admin/realms/pms/users/?username=" + username;
			HttpHeaders headersUserid = new HttpHeaders();
			headersUserid.setContentType(MediaType.APPLICATION_JSON);
			headersUserid.add("Authorization", "Bearer " + tokenAdmin);
			HttpEntity<String> requestUserid = new HttpEntity<>(headersUserid);
			ResponseEntity respUserid = restTemplate.exchange(urlUserid, HttpMethod.GET, requestUserid,
					String.class);
			JSONArray useridJson = new JSONArray(respUserid.getBody().toString());

			/**
			 * Role Mapping
			 */
			String urlRole = "http://localhost:8180/auth/admin/realms/pms/users/"+ useridJson.getJSONObject(0).get("id") + "/role-mappings/realm";
			HttpHeaders headersRole = new HttpHeaders();
			headersRole.setContentType(MediaType.APPLICATION_JSON);
			headersRole.add("Authorization", "Bearer " + tokenAdmin);

			/**
			 * Checking for Nurse or Physician
			 */
			JSONObject roleParam = new JSONObject();
			if(dto.getRoleId()==3) {
				/**
				 * Physician
				 */
				roleParam.put("id",physicianId );
				roleParam.put("name", "physician");	
			}
			
			else if(dto.getRoleId()==4) {
				/**
				 * Nurse
				 */
				roleParam.put("id", nurseId);
				roleParam.put("name", "nurse");	
			}
			
			else if(dto.getRoleId()==2) {
				/**
				 * Admin
				 */
				roleParam.put("id", adminId);
				roleParam.put("name", "admin");	
			}
			
			

			JSONArray roleArray = new JSONArray();
			roleArray.put(roleParam);

			HttpEntity<String> requestRole = new HttpEntity<String>(roleArray.toString(), headersRole);
			restTemplate.exchange(urlRole, HttpMethod.POST, requestRole, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateUserPasswordInKeyclock(String username, String password) {

//		try {

		String url = "http://localhost:8180/auth/realms/pms/protocol/openid-connect/token";

		/**
		 * Admin password
		 */
		MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("client_id", clientId);
		requestParams.add("username", adminUsername);
		requestParams.add("password", adminPassword);
		requestParams.add("grant_type", "password");
		requestParams.add("client_secret", clientSecret);
		requestParams.add("scope", "openid");

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
		AccessTokenResponse keycloakAccessToken = getAccessTokenResponse(request, url);
		String tokenAdmin = keycloakAccessToken.getToken().trim();

		/**
		 * User id
		 */
		String urlUserid = "http://localhost:8180/auth/admin/realms/pms/users/?username=" + username;
		HttpHeaders headersUserid = new HttpHeaders();
		headersUserid.setContentType(MediaType.APPLICATION_JSON);
		headersUserid.add("Authorization", "Bearer " + tokenAdmin);
		HttpEntity<String> requestUserid = new HttpEntity<String>(headersUserid);
		ResponseEntity respUserid = restTemplate.exchange(urlUserid, HttpMethod.GET, requestUserid, String.class);
		JSONArray useridJson = new JSONArray(respUserid.getBody().toString());

		/**
		 * Update Password
		 */
		String urlUpdatepwd = "http://localhost:8180/auth/admin/realms/pms/users/"
				+ useridJson.getJSONObject(0).get("id") + "/reset-password";
		HttpHeaders headersUpdatepwd = new HttpHeaders();
		headersUpdatepwd.setContentType(MediaType.APPLICATION_JSON);
		headersUpdatepwd.add("Authorization", "Bearer " + tokenAdmin);

		JSONObject updatepwdParam = new JSONObject();
		updatepwdParam.put("type", "password");
		updatepwdParam.put("temporary", "false");
		updatepwdParam.put("value", password);

//			JSONArray updatepwdArray = new JSONArray();
//			updatepwdArray.put(updatepwdParam);

		HttpEntity<String> requestUpdatepwd = new HttpEntity<String>(updatepwdParam.toString(), headersUpdatepwd);
		ResponseEntity respUpdatepwd = restTemplate.exchange(urlUpdatepwd, HttpMethod.PUT, requestUpdatepwd,
				String.class);
		System.out.println(respUpdatepwd.getBody());

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
