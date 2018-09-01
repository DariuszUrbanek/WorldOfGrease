package com.example.du.shop.plugin;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
 
public class CustomStrategy extends DelegatingReverseEngineeringStrategy {
 
    public CustomStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }
    
    @Override
    public String getTableIdentifierStrategyName(TableIdentifier tableIdentifier) {
    	
    	return "identity";
    }
    
    
}