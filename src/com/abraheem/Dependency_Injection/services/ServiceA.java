package com.abraheem.Dependency_Injection.services;
import com.abraheem.Dependency_Injection.interfaces.*;

public class ServiceA implements Service {
    @Override
    public String getInfo() {
        return "Service A Info";
    }
}
