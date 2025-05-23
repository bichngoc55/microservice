package com.demo.apigateway.routes;

import org.springframework.beans.factory.annotation.Value; 
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; 
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;
 

@Configuration
public class Routes {
//    @Value("${product.service.url}")
//    private String productServiceUrl;
//    @Value("${order.service.url}")
//    private String orderServiceUrl;
//    @Value("${inventory.service.url}")
//    private String inventoryServiceUrl;
 
//    }
    @Bean
    public RouterFunction<ServerResponse> productServiceRoute() {
        return GatewayRouterFunctions.route("product_service")
                .route(RequestPredicates.path("/api/product/**"),
                        HandlerFunctions.http("http://product-service:8083/api/product"))
                .build();
    }


    @Bean
    public RouterFunction<ServerResponse> orderServiceRoute() {
        return GatewayRouterFunctions.route("order_service")
                .route(RequestPredicates.path("/api/order/**"), 
                // HandlerFunctions.http(orderServiceUrl))
        HandlerFunctions.http("http://order-service:8081/api/order"))

                .build();
    }


    @Bean
    public RouterFunction<ServerResponse> inventoryServiceRoute() {
        return GatewayRouterFunctions.route("inventory_service")
                .route(RequestPredicates.path("/api/inventory/**"),
                // HandlerFunctions.http(inventoryServiceUrl))
        HandlerFunctions.http("http://inventory-service:8082/api/inventory"))

                .build();
    }
 

}
