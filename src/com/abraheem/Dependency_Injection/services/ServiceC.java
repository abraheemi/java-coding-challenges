package com.abraheem.Dependency_Injection.services;
import com.abraheem.Dependency_Injection.interfaces.*;

public class ServiceC implements Service {
    @Override
    public String getInfo() {
        return "Service C Info";
    }
}
