package com.abraheem.Dependency_Injection.clients;
import com.abraheem.Dependency_Injection.interfaces.*;

public class ClientA implements Client {
    Service service;

    public ClientA(Service service){
        this.service = service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public void doSomething() {
        String info = service.getInfo();
        System.out.println(info);
    }
}
