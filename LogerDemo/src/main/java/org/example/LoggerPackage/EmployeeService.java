package org.example.LoggerPackage;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeService {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    public void addEmployee(String name){
        logger.info("employe creation started");
        if (name==null){
            logger.error("employee con not be null");
            throw new IllegalStateException("employee not found 404");
        }else{
            logger.debug("Employee{}logged.in",name);
            logger.info("Employee{}created",name);
        }
        logger.info("employee registerd");

    }
}
