package service;

import exception.UnauthorizationFailForResource;
import model.Employee;
import policy.Policy;
import policy.PolicyResolver;

public class AuthorizationService {

    public static <T> void isAuthorized(Employee currentUser, T resource, String action) throws UnauthorizationFailForResource {
        Policy<T> policy = (Policy<T>) PolicyResolver.getPolicy(resource.getClass());
        if(policy == null){
            throw new IllegalArgumentException("No Policy Fount for class: "+ resource.getClass().getName());
        }

        boolean result = switch (action){
            case "create" -> policy.canCreate(resource, currentUser);
            case "view" -> policy.canView(resource, currentUser);
            case "update" -> policy.canUpdate(resource, currentUser);
            case "delete" -> policy.canDelete(resource, currentUser);
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };

        if(!result){
            throw new UnauthorizationFailForResource("Can not access the "+action+" permission for" + (resource.getClass().getName()) );
        }
    }

}
