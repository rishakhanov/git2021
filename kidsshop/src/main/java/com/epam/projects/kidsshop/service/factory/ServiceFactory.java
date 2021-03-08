package com.epam.projects.kidsshop.service.factory;

import com.epam.projects.kidsshop.service.*;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

    private ServiceFactory() {
    }

    static {
        SERVICE_MAP.put("/KIDSSHOP/LOGIN", new LoginService());
        SERVICE_MAP.put("/KIDSSHOP/LOGOUT", new LogoutService());
        SERVICE_MAP.put("/KIDSSHOP/PRODUCTADD", new AddProductService());
        SERVICE_MAP.put("/KIDSSHOP/PRODUCTUPDATE", new UpdateProductService());
        SERVICE_MAP.put("/KIDSSHOP/USERADD", new AddUserService());
        SERVICE_MAP.put("/KIDSSHOP/PRODUCTSSHOW", new ShowProductService());
        SERVICE_MAP.put("/KIDSSHOP/CARSSHOW", new ShowCarService());
        SERVICE_MAP.put("/KIDSSHOP/CONSTRUCTORSSHOW", new ShowConstructorsService());
        SERVICE_MAP.put("/KIDSSHOP/STUFFEDTOYSSHOW", new ShowStuffedToysService());
        SERVICE_MAP.put("/KIDSSHOP/BUYCAR", new BuyCarService());
        SERVICE_MAP.put("/KIDSSHOP/HOMEPAGESHOW", new ShowHomePageService());
        SERVICE_MAP.put("/KIDSSHOP/CARTSHOW", new ShowCartService());
        SERVICE_MAP.put("/KIDSSHOP/DELETEORDERITEM", new DeleteOrderItemService());
    }

    public Service getService(String request) {
        Service service = SERVICE_MAP.get("/ERROR");

        for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = SERVICE_MAP.get(pair.getKey());
            }
        }
        return service;
    }

    public static ServiceFactory getInstance() {
        return SERVICE_FACTORY;
    }
}
