package com.epam.core;

import com.epam.workload.dto.employee.language.Language;
import com.epam.workload.rest.client.RestClient;
import com.epam.workload.rest.client.UpsaRestClient;
import com.epam.workload.rest.client.token.CredentialTypes;
import com.epam.workload.rest.client.token.Credentials;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import javax.ws.rs.core.MultivaluedMap;

public class UpsaRestClientExamples {
    public UpsaRestClientExamples() {
    }

    public static void main(String[] args) {
        RestClient restClient = new UpsaRestClient("https://upsa.epam.com/workload/rest/v3/oauth/token", true);
        Credentials domainCredentials = new Credentials("Vasyl_Naulychnyi", "", CredentialTypes.DOMAIN);
        Credentials credentials = new Credentials("Vasyl_Naulychnyi", "", CredentialTypes.DOMAIN);
        System.out.println("Get OutlookAttendee using Domain UpsaClientProperties:");
        System.out.println(restClient.get("https://upsa.epam.com/workload/rest/v3/employees/313870", null, domainCredentials));
        System.out.println("");
        System.out.println("Get OutlookAttendee using PMC UpsaClientProperties:");
        System.out.println(restClient.get("https://upsa.epam.com/workload/rest/v3/employees/313870", null, credentials));
        System.out.println("");
//        EmployeeComposeObject employeeComposeObject = (EmployeeComposeObject)restClient.get("https://upsa.epam.com/workload/rest/v3/employees/313870", (MultivaluedMap)null, EmployeeComposeObject.class, credentials);
//        System.out.println("Get OutlookAttendee Java Object:");
//        System.out.println(employeeComposeObject);
        System.out.println("");
        MultivaluedMap<String, String> params = new MultivaluedMapImpl();
        params.add("cefrAssessmentOnly", "true");
        System.out.println("Get List of Language:");
        System.out.println(restClient.getArray("https://upsa.epam.com/workload/rest/v3/employees/language-assessments/languages", params, credentials));
        System.out.println("");
        System.out.println("List of Language Java Objects:");
        System.out.println(restClient.getArray("https://upsa.epam.com/workload/rest/v3/employees/language-assessments/languages", params, Language.class, credentials));
        System.out.println("");
        params.clear();
        params.add("countryId", "85");
        System.out.println("Updating company external reporting country:");
//        restClient.voidPut("https://upsa.epam.com/workload/rest/v3/", params, credentials);
        System.out.println("ok");
    }
}