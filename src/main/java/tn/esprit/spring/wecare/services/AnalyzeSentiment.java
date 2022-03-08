package tn.esprit.spring.wecare.services;

import com.azure.ai.textanalytics.TextAnalyticsAsyncClient;
import com.azure.ai.textanalytics.TextAnalyticsClient;
import com.azure.ai.textanalytics.TextAnalyticsClientBuilder;
import com.azure.ai.textanalytics.models.DocumentSentiment;
import com.azure.ai.textanalytics.models.SentimentConfidenceScores;
import com.azure.core.credential.AzureKeyCredential;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.wecare.controllers.ComplaintController;
import tn.esprit.spring.wecare.entities.Complaint;
import tn.esprit.spring.wecare.services.models.confidenceScores;
import tn.esprit.spring.wecare.services.models.jsonDocument;

/**
 * Sample demonstrates how to analyze the sentiment of document.
 */
@Slf4j
@Service
public class AnalyzeSentiment {
   
	public  confidenceScores  analyze(String description) throws JsonProcessingException
	{
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.add("Ocp-Apim-Subscription-Key","7cc8098b36f04a09a0b8133203291705");
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Map<String, List<Map<String,String>>> bodyParamMap = new HashMap<String, List<Map<String,String>>>();
		Map	<String,String> document = new HashMap<String,String>();
		document.put("language", "en");
		document.put("id", "1");
		document.put("text", description);
		List<Map<String,String>> documents = new ArrayList<Map<String,String>>();
		documents.add(document);
		bodyParamMap.put("documents", documents);
		String reqBodyData = new ObjectMapper().writeValueAsString(bodyParamMap);
       
		HttpEntity<String> requestEnty = new HttpEntity(reqBodyData, headers);

		
		ResponseEntity<Object> result = restTemplate.postForEntity("https://bali.cognitiveservices.azure.com/text/analytics/v3.1/sentiment?opinionMining=true", 
				
				requestEnty, Object.class);
			
		
		log.info(result.getBody().toString());
		
		jsonDocument myObjects = new ObjectMapper().readValue(
				
				new ObjectMapper().writeValueAsString(result.getBody())	, jsonDocument.class);
		
//		List<tn.esprit.spring.wecare.services.models.documents> myObjects = Arrays.asList( new ObjectMapper().readValue(result.getBody().toString(), tn.esprit.spring.wecare.services.models.documents[].class));

         return    myObjects.getDocuments().get(0).getConfidenceScores();
		

        
		
		
		

		

		

		
//		TextAnalyticsClient textAnalyticsClient = new TextAnalyticsClientBuilder()
//			    .credential(new AzureKeyCredential("7cc8098b36f04a09a0b8133203291705"))
//			    .endpoint("https://bali.cognitiveservices.azure.com/text/analytics/v3.0/sentiment")
//			    .buildClient();
//		log.info(textAnalyticsClient.toString());
////		String document = "The hotel was dark and unclean. I like microsoft.";
//		final DocumentSentiment documentSentiment = textAnalyticsClient.analyzeSentiment(description);
//	//	System.out.printf("Analyzed document sentiment: %s.%n", documentSentiment.getSentiment());
////	 	documentSentiment.getSentences().forEach(sentenceSentiment ->
//	//	    System.out.printf("Analyzed sentence sentiment: %s.%n", sentenceSentiment.getSentiment()));
//		
//		
//	return documentSentiment.getConfidenceScores().toString();
		
		
		
		
		
		
		
		
		
		
		
		
		

        //HttpClient httpclient = HttpClients.createDefault();
//        try
//        {
//            URIBuilder builder = new URIBuilder("https://bali.cognitiveservices.azure.com/text/analytics/v3.0/sentiment");
//
//            builder.setParameter("model-version", "{string}");
//            builder.setParameter("showStats", "{boolean}");
//            builder.setParameter("opinionMining", "{boolean}");
//            builder.setParameter("stringIndexType", "TextElements_v8");
//          
//            URI uri = builder.build();
//            HttpPost request = new HttpPost(uri);
//            request.setHeader("Content-Type", "application/json");
//            request.setHeader("Ocp-Apim-Subscription-Key", "7cc8098b36f04a09a0b8133203291705");


            // Request body
            
     /*       StringEntity reqEntity = new StringEntity("{body}");
          
            request.setEntity(reqEntity);

            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();
            String x=  EntityUtils.toString(entity);

            if (entity != null) 
            {
                System.out.println(EntityUtils.toString(entity));
                return x;
            }
			return x;
            
	}*/
	
}}
//        }
//        catch (Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
       // return EntityUtils.toString(entity);
//		return document;

  
	//	return EntityUtils.toString(entity,);
		
//    }
       
        
    
