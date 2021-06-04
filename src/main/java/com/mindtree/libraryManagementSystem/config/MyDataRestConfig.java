package com.mindtree.libraryManagementSystem.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
//import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

//import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer{

	@Autowired
	private EntityManager entityManager;
	
	
	public MyDataRestConfig(EntityManager entityManager) {
		entityManager=entityManager;
	}
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// TODO Auto-generated method stub
//		HttpMethod[] theUnsupportedActions = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
//		//disable hhtp for product:put,post,delete
//		disableHttpMethods(Product.class,config, theUnsupportedActions);//RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
//	
//		//disable hhtp for productCategory:put,post,delete
//		disableHttpMethods(ProductCategory.class,config, theUnsupportedActions);
//		disableHttpMethods(Country.class,config, theUnsupportedActions);
//		disableHttpMethods(State.class,config, theUnsupportedActions);
				
			exposeIds(config);	
	}

	private void disableHttpMethods(Class theClass,RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration()
		.forDomainType(theClass)
		.withItemExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metdata,httpMethods)->httpMethods.disable(theUnsupportedActions));
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {
		//expose entity ids
		
		//get a list of all entity classes from the entity manager
		Set<EntityType<?>>entities=entityManager.getMetamodel().getEntities();
		
		//create an array of the entity types
		List<Class>entityClasses=new ArrayList<>();
		
		//get the entity types for the entities
		for(EntityType tempEntityType:entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		
		//expose the entity ids for the array of entity/domain types
		 Class[] domainTypes=entityClasses.toArray(new Class[0]);
		 config.exposeIdsFor(domainTypes);
	}
	
	

}