package com.epam.core;


import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bouncycastle.util.Arrays;

import com.epam.NLP.NLPService;
import com.epam.logicClasses.LogicStaff;
import com.epam.logicClasses.MethodService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.aad.adal4j.AuthenticationException;
import com.microsoft.bot.connector.customizations.CredentialProvider;
import com.microsoft.bot.connector.customizations.JwtTokenValidation;
import com.microsoft.bot.connector.customizations.MicrosoftAppCredentials;
import com.microsoft.bot.connector.implementation.ConnectorClientImpl;
import com.microsoft.bot.schema.models.Activity;
import com.microsoft.bot.schema.models.ActivityTypes;
import com.microsoft.bot.schema.models.ResourceResponse;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MessageHandlerProxy implements HttpHandler{

	
	private ObjectMapper objectMapper;
	private CredentialProvider credentialProvider;
	private MicrosoftAppCredentials credentials;
	private HttpExchange httpExchange;
	private NLPService nlpService;
	private Map<String, LogicStaff> methods = new MethodService().getMethods();
	private String result;
	
	
	private static final Logger LOGGER = Logger.getLogger(CoreLogic.class.getName());
	private static String appId = ""; // <-- app id -->
	private static String appPassword = ""; // <-- app password -->
	
	
	
	MessageHandlerProxy(CredentialProvider credentialProvider) {
		this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.findAndRegisterModules();
		this.credentialProvider = credentialProvider;
//		this.httpExchange = httpExchange;
		this.credentials = new MicrosoftAppCredentials(appId, appPassword);
		
		//set all methods
		setMethods();
	}
	
	
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		if (httpExchange.getRequestMethod().equalsIgnoreCase("POST")) {
			Activity activity = getActivity(httpExchange);
			String authHeader = httpExchange.getRequestHeaders().getFirst("Authorization");
			try {
				JwtTokenValidation.assertValidActivity(activity, authHeader, credentialProvider);

				// send ask to user activity
				httpExchange.sendResponseHeaders(202, 0);
				httpExchange.getResponseBody().close();

				if (activity.type().equals(ActivityTypes.MESSAGE)) {

					if (securityCheckMessage(activity.text())) {
						sendMessageToNLPService(activity.text());
						if(methods.get(getProcessedMethodFromNLPServise()).processed(getProcessedArgumentsFromNLPServise()))  
							result = methods.get(getProcessedMethodFromNLPServise()).getResultMessage();
						if (result.toLowerCase().contains("empty"))
							result = new String(activity.text());
						
													
							ConnectorClientImpl connector = new ConnectorClientImpl(activity.serviceUrl(),
									this.credentials);
							ResourceResponse response = connector.conversations().sendToConversation(
									activity.conversation().id(),
									new Activity()
												.withType(ActivityTypes.MESSAGE)
												.withText(result)
												.withRecipient(activity.from())
												.withFrom(activity.recipient()));
						
						
					}
				}
			} catch (AuthenticationException ex) {
				httpExchange.sendResponseHeaders(401, 0);
				httpExchange.getResponseBody().close();
				LOGGER.log(Level.WARNING, "Auth failed!", ex);
			} catch (Exception ex) {
				LOGGER.log(Level.WARNING, "Execution failed", ex);
			}
		}
	}
	
	private String getRequestBody(HttpExchange httpExchange) throws IOException {
		StringBuilder buffer = new StringBuilder();
		InputStream stream = httpExchange.getRequestBody();
		int rByte;
		while ((rByte = stream.read()) != -1) {
			buffer.append((char) rByte);
		}
		stream.close();
		if (buffer.length() > 0) {
			return buffer.toString();
		}
		return "";
	}

	private Activity getActivity(HttpExchange httpExchange) {
		try {
			String body = getRequestBody(httpExchange);
			LOGGER.log(Level.INFO, body);
			return objectMapper.readValue(body, Activity.class);
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING, "Failed to get activity", ex);
			return null;
		}

	}

	private boolean securityCheckMessage(String inputMessage) {

		// some security logic
		if (!inputMessage.contains("hack")) {
			return true;
		} else
			return false;
	}

	private void sendMessageToNLPService(String userMessage) {
		nlpService = new NLPService(userMessage);
	}

	private String getProcessedMethodFromNLPServise() {
		return nlpService.processedResult().get(0);
	}

	private String[] getProcessedArgumentsFromNLPServise() {
		String[] args = new String[nlpService.processedResult().size() - 1];
		for(int i = 0; i < nlpService.processedResult().size() - 1; i++) {
			args[i] = nlpService.processedResult().get(i + 1);
		}
		return args;

	}
	
	public void setMethods() {
		this.methods = new MethodService().getMethods();
	}

}
