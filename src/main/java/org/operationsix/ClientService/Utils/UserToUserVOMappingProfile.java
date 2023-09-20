package org.operationsix.ClientService.Utils;


import org.modelmapper.ModelMapper;
import org.operationsix.ClientService.dto.UserVO;
import org.operationsix.ClientService.models.User;

public class UserToUserVOMappingProfile {
    private final static ModelMapper model= new ModelMapper();;
    public static UserVO map(User user){
        return model.map(user, UserVO.class);
    }
}
