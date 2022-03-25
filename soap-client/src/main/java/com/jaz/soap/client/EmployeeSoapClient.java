package com.jaz.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class EmployeeSoapClient extends WebServiceGatewaySupport implements DataConsumer<GetEmployeeResponse>{

    public GetEmployeeResponse getEmployee(int id){
        GetEmployeeRequest employeeRequest = new GetEmployeeRequest();
        employeeRequest.setId(id);
        return (GetEmployeeResponse) getWebServiceTemplate().marshalSendAndReceive(employeeRequest);
    }

    @Override
    public GetEmployeeResponse fetchData() {
        return getEmployee(11);
    }
}
